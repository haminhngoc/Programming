import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		VSTEPS solver = new VSTEPS();
		solver.solve(in, out);
		out.close();
	}
}

class VSTEPS {
    public void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        boolean[] cannotJum = new boolean[n+1];
        for (int i = 0; i < k; i++) {
            cannotJum[in.nextInt()] = true;
        }
        long[] dp = new long[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if(cannotJum[i]) continue;
            dp[i] = dp[i-1] + dp[i-2];
            if(dp[i] >= 14062008){
                dp[i] -= 14062008;
            }
        }
        out.println(dp[n]);
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

