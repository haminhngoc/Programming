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
		C11ID solver = new C11ID();
		solver.solve(1, in, out);
		out.close();
	}
}

class C11ID {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int BASE = (int)1e9+7;
        Long[] a = new Long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        Arrays.sort(a);
        long res = 1;
        for (int i = 0; i < n; i++) {
            res *= (a[i]-i);
            res %= BASE;
        }
        res %= BASE;
        out.println(res);
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

    public long nextLong() {
        return Long.parseLong(next());
    }

}
