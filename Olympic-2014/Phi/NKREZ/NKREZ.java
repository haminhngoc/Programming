import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
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
        Request[] rs = new Request[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            rs[i] = new Request();
            rs[i].in = in.nextInt();
            rs[i].out = in.nextInt();
            max = Math.max(max,rs[i].out);
        }
        Arrays.sort(rs);
        long[] dp = new long[max+1];
        long res = 0;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j <= rs[i].in; ++j){
                dp[rs[i].out] = Math.max(dp[rs[i].out],dp[j] + rs[i].out - rs[i].in);
            }
			res = Math.max(dp[rs[i].out],res);
        }
        out.println(res);
    }
}

class Request implements Comparable<Request>{
    int in;
    int out;
    public int compareTo(Request other) {
        return out - other.out;
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

