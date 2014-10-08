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

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int c = in.nextInt();
        int n = in.nextInt();
        long[][] dp = new long[n+1][c+1];
        int[] w = new int[n+1];
        for(int i = 1; i <= n; ++i){
            w[i] = in.nextInt();
        }
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j <= c; ++j){
                dp[i][j] = dp[i-1][j];
                if(j >= w[i]){
                    dp[i][j] = Math.max(dp[i][j], w[i] + dp[i-1][j-w[i]]);
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

