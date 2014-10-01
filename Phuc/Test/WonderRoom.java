import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WonderRoom {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		long n = nextLong();
		long a = nextLong();
		long b = nextLong();
		long min = Math.min(a, b);
		long max = Math.max(a, b);
		if (a * b >= 6 * n) {
			System.out.println(a * b);
			System.out.println(a + " " + b);
		} else {
			long temp = 6 * n;
			long end = (6 * n + min);

			for (; temp <= end; ++temp) {
				long t = (long) Math.sqrt(temp);

				for (long i = min; i <= t; ++i) {
					if (temp % i == 0 && temp / i >= max) {
						if (b >= a) {
							System.out.println(temp);
							System.out.println(i + " " + (temp / i));
							return;
						} else {
							System.out.println(temp);
							System.out.println((temp / i) + " " + i);
							return;
						}
					}
				}
			}
		}

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
