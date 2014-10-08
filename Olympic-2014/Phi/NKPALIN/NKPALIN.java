import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskSPOJ solver = new TaskSPOJ();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskSPOJ {

    public char[] getLCS(char[] x, char[] y) {
        int m = x.length;
        int n = y.length;
        int[][] lcs = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (x[i] == y[j]) {
                    lcs[i + 1][j + 1] = lcs[i][j] + 1;
                } else {
                    lcs[i + 1][j + 1] = Math.max(lcs[i + 1][j], lcs[i][j + 1]);
                }
            }
        }
        int cnt = lcs[m][n];
        char[] res = new char[cnt];
        for (int i = m - 1, j = n - 1; i >= 0 && j >= 0; ) {
            if (x[i] == y[j]) {
                res[--cnt] = x[i];
                --i;
                --j;
            } else if (lcs[i + 1][j] > lcs[i][j + 1]) {
                --j;
            } else {
                --i;
            }
        }
        return res;
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.next();
        char[] x = s.toCharArray();
        int length = s.length();

        StringBuilder a =  new StringBuilder();
        a.append(new String(x));
        char[]y = a.reverse().toString().toCharArray();
        
        char[] lcs = getLCS(x, y);
        out.println(new String(lcs));
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

}

