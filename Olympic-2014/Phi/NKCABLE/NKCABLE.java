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
        int n = in.nextInt();
        int[] d = new int[n-1];
        for (int i = 0; i < n - 1; i++) {
            d[i] = in.nextInt();
        }
        if(n == 1){
            out.println(0);
            return;
        }
        if(n == 2){
            out.println(d[0]);
            return;
        }
        if(n == 3){
            out.println(d[0] + d[1]);
            return;
        }
        int[] dp = new int[n];
        dp[1] = d[0];
        dp[2] = d[0] + d[1];
        for(int i = 3; i < n; ++i){
            dp[i] = Math.min(dp[i-1],dp[i-2])  + d[i-1];
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

