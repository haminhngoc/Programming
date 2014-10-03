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
        ChuoiDoiXung_2118 solver = new ChuoiDoiXung_2118();
        solver.solve(1, in, out);
        out.close();
    }
}

class ChuoiDoiXung_2118 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        char[] a = in.next().toCharArray();
        int length = a.length;
        StringBuilder c = new StringBuilder();
        c.append(a);
        char[] b = c.reverse().toString().toCharArray();
        for (int i = length - 1; i >= 0; i--) {
            b[i] = a[length - 1 - i];
        }
        int[][] dp = new int[length + 1][length + 1];
        for (int i = 1; i <= length; i++) {
            for (int j = 1; j <= length; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = length - 1;
        int j = length - 1;
        StringBuilder res = new StringBuilder();
        while (i >= 0 && j >= 0) {
            if (a[i] == b[j]) {
                res.append(a[i]);
                i--;
                j--;
            } else {
                if (dp[i][j + 1] >= dp[i + 1][j]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        out.println(res);
    }

}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
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

