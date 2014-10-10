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
		NKBUS solver = new NKBUS();
		solver.solve(1, in, out);
		out.close();
	}
}

class NKBUS {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        Long[] waitTime = new Long[2 * (int) (1e5)];
       // Arrays.fill(waitTime, Long.MAX_VALUE);
        long totalTime = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            int timeToNextStation = in.nextInt();
            int k = in.nextInt();
            for (int j = 0; j < k; j++) {
                int pi = in.nextInt();
                waitTime[index] = (pi - totalTime <= 0 ? 0 : pi - totalTime);
                index++;
            }
            totalTime += timeToNextStation;
        }
        Arrays.sort(waitTime,0,index);
        long res = totalTime + waitTime[(m - 1)];
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

    public int nextInt() {
        return Integer.parseInt(next());
    }

}

