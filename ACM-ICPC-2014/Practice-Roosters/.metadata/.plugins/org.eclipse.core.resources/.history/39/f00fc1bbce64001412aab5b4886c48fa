import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}
}

class Task {
	public void solve(InputReader in, PrintWriter out) {
		int MAX = (int) 1e6;
		long[] cache = new long[MAX + 1];
		long[] cache1 = new long[MAX + 1];
		long[] cache2 = new long[MAX + 1];
		cache[1] = 1;
		for (long i = 3; i <= MAX; i += 2) {
			cache[(int) i] = cache[(int) (i - 2)] + i;
			cache1[(int) i] = cache1[(int) (i - 2)] + (i - 1) * i;
			cache2[(int) i] = cache2[(int) (i - 2)] + (i - 1) * (i - 1) * i;
		}
		long m, n;
		n = in.nextLong();
		m = in.nextLong();
		long r;
		long temp;
		StringBuilder res = new StringBuilder();
		while (n + m > 0) {
			r = Math.min(n, m);
			if ((r & 1) == 0)
				--r;
			temp = cache[(int) r] * m * n - cache1[(int) r] * (m + n)
					+ cache2[(int) r];
			res.append(temp);
			res.append("\n");
			n = in.nextLong();
			m = in.nextLong();
		}
		out.print(res);
	}

}

class InputReader {
	BufferedReader reader;
	StringTokenizer tokenizer;

	InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				e.printStackTrace();
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