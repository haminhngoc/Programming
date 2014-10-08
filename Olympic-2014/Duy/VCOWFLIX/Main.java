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
		DiXemPhim_2720 solver = new DiXemPhim_2720();
		solver.solve(1, in, out);
		out.close();
	}
}

class DiXemPhim_2720 {
    static int[] a;
    static int c;
    static int n;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        c = in.nextInt();
        n = in.nextInt();
        a = in.nextAi(n);
        int[][] dp = new int[n + 1][c + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= c; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= a[i - 1] && dp[i][j] < dp[i - 1][j - a[i - 1]] + a[i - 1]) {
                    dp[i][j] = dp[i - 1][j - a[i - 1]] + a[i - 1];
                }
            }
        }
        out.println(dp[n][c]);
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

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public int[] nextAi(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
    }

}

