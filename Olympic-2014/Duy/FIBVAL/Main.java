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
		FIBVAL solver = new FIBVAL();
		solver.solve(1, in, out);
		out.close();
	}
}

class FIBVAL {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int nTest = in.nextInt();
        while ((nTest--) > 0) {
            // loop CDEGCABAAGFDACBC length 16

            int from = in.nextInt();
            int to = in.nextInt();
            int start = from % 16 == 0 ? 16 : from % 16;
            int end = to % 16 == 0 ? 16 : to % 16;
            int res = 0;
            if (to - from + 1 < 16 && end > start && (start >= 1 && end <= 8 || (start >= 9 && end <= 16))) {
                out.println(-1);
                continue;
            } else {
                res = 2;
            }
            res = Math.max(res, ((to - from + 1) / 16) * 16);
            res = res == 16 ? 2 : res;
            out.println(res);
        }
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

