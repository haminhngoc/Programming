import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();

		int s = nextInt();
		int max = -1;
		for (int i = 0; i < n; ++i) {
			int x = nextInt();
			int y = nextInt();

			if (x * 100 + y > s * 100) {
				continue;
			}
			if (y == 0 && max != -1) {
				continue;
			} else if (y == 0 && max == -1) {
				max = 0;
			} else {
				max = Math.max(max, 100 - y);
			}
		}

		System.out.println(max);

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
