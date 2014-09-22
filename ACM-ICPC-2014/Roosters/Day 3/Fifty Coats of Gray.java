import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

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
		long n = in.nextLong();
		long w = in.nextLong();
		long l = in.nextLong();
		long h = in.nextLong();
		long a = in.nextLong();
		long m = in.nextLong();

		while (n != 0 || w != 0 || l != 0 || h != 0 || a != 0 || m != 0) {
			long sum = 0;
			sum = (l + w) * 2 * h + l * w;
			for (int i = 0; i < m; ++i) {
				long t = in.nextLong();
				long k = in.nextLong();
				sum -= t * k;
			}
			sum *= n;
			System.out.println(sum % a == 0 ? sum / a : (sum / a + 1));
			n = in.nextLong();
			w = in.nextLong();
			l = in.nextLong();
			h = in.nextLong();
			a = in.nextLong();
			m = in.nextLong();
		}
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

	public double nextDouble() {
		return Double.parseDouble(next());
	}

}
