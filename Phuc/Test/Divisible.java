import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Divisible {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		int k = nextInt();
		boolean a[][] = new boolean[n][k];
		int t = nextInt();
		a[0][t % k] = true;
		for (int i = 1; i < n; ++i) {
			t = nextInt();
			for (int j = 0; j < k; ++j) {
				if (a[i - 1][j]) {
					if (j + t < 0) {
						a[i][(k + (j + t) % k) % k] = true;
					} else {
						a[i][(j + t) % k] = true;
					}

					if (j - t < 0) {
						a[i][(k + (j - t) % k) % k] = true;
					} else {
						a[i][(j - t) % k] = true;
					}
				}
			}
		}
		System.out.println(a[n - 1][0] ? "Divisible" : "Not divisible");

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
