import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
		int nTest = in.nextInt();
		for (int id = 1; id <= nTest; ++id) {
			long l = in.nextLong();
			long m = in.nextLong();
			long n = in.nextLong();

			l *= l;

			long temp = l - m;
			long BASE = (long) (1e13 + 7);

			long value = 1;
			for (long i = l; i > temp; --i) {
				value *= i;
				value %= BASE;
			}

			long result = 0;

			for (long i = m; i <= n; ++i) {
				result += value;
				result %= BASE;
				value *= temp--;
				value %= BASE;
				// System.out.println(value);
			}
			System.out.println("Case " + id + ": " + result);

		}
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