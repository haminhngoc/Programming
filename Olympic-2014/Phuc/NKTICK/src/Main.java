import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		int t[] = new int[n];
		for (int i = 0; i < n; ++i) {
			t[i] = nextInt();
		}

		int r[] = new int[n - 1];
		for (int i = 0; i < n - 1; ++i) {
			r[i] = nextInt();
		}

		long a[] = new long[n];
		long b[] = new long[n];
		a[0] = t[0];
		b[0] = t[0];

		for (int i = 1; i < n; ++i) {
			a[i] = Math.min(a[i - 1] + t[i], b[i - 1] + t[i]);
			b[i] = a[i - 1] + r[i - 1] - t[i - 1];
		}
		System.out.println(Math.min(a[n - 1], b[n - 1]));
	}

	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
