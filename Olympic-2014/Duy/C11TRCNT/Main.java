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
		C11TRCNT solver = new C11TRCNT();
		solver.solve(1, in, out);
		out.close();
	}
}

class C11TRCNT {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        long[] x = new long[n];
        long[] y = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.nextLong();
            y[i] = in.nextLong();
        }
        if (n < 3) {
            out.println(0 + " " + 1);
            return;
        }
        long nProtectLevel = 0;
        long[] ProtectLevel = new long[n];
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (x[i] * (y[j] - y[k]) + x[j] * (y[k] - y[i]) + x[k] * (y[i] - y[j]) == 0) {
                        continue;
                    }
                    nProtectLevel++;
                    ProtectLevel[i]++;
                    ProtectLevel[j]++;
                    ProtectLevel[k]++;
                }
            }
        }
        long smallestFly = 0;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (ProtectLevel[i] < min) {
                min = ProtectLevel[i];
                smallestFly = i + 1;
            }
        }
        out.println(nProtectLevel + " " + smallestFly);
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

    public long nextLong() {
        return Long.parseLong(next());
    }

}