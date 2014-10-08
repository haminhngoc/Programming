import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();

		double x[] = new double[n];
		double y[] = new double[n];

		for (int i = 0; i < n; ++i) {
			x[i] = NextDouble();
			y[i] = NextDouble();
		}

		long min = Long.MAX_VALUE;
		long p = 0;
		long count[] = new long[n];
		long z = 0;
		for (int i = 0; i < n; ++i) {

			for (int j = i + 1; j < n; ++j) {

				for (int k = j + 1; k < n; ++k) {

					if (x[i] * (y[j] - y[k]) + x[j] * (y[k] - y[i]) + x[k]
							* (y[i] - y[j]) == 0) {
						continue;
					}
					count[i]++;
					count[j]++;
					count[k]++;
					z++;
				}
			}

		}

		for (int i = 0; i < n; ++i) {
			if (count[i] < min) {
				min = count[i];
				p = i + 1;
			}
		}
		System.out.println(z + " " + p);

	}

	static double distance(double x, double y, double x2, double k2) {
		return Math.sqrt((x - x2) * (x - x2) + (y - k2) * (y - k2));
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
