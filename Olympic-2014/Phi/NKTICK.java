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
		TaskNKTICK solver = new TaskNKTICK();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskNKTICK {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] t = new int[n];
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = in.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            r[i] = in.nextInt();
        }

        int[] dp = new int[n];
        dp[0] = t[0];
        dp[1] = Math.min(dp[0] + t[1], r[0]);
        for (int i = 2; i < n; ++i) {
            dp[i] = Math.min(dp[i-1] + t[i], dp[i-2] + r[i-1]);
        }
        out.println(dp[n-1]);
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

    public int nextInt() {
        return Integer.parseInt(next());
    }

}

