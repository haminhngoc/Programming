import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Present {
	static long a[];
	static int n;
	static int m;
	static int w;

	public static void main(String[] args) throws IOException {
		Init(System.in);
		n = nextInt();
		m = nextInt();
		w = nextInt();

		a = new long[n];
		long max = Long.MIN_VALUE;
		for (int i = 0; i < n; ++i) {
			a[i] = nextLong();
			if (a[i] > max) {
				max = a[i];
			}
		}

		long left = 0;
		long right = max + m + 1;

		while (left < right) {
			long mid = (left + right + 1) >> 1;
			if (check(mid)) {
				left = mid;

			} else {
				right = mid - 1;
			}
		}

		System.out.println(left);
	}

	private static boolean check(long mid) {
		long b[] = new long[n + w];
		long up = 0;
		long day = 0;
		for (int i = 0; i < n; ++i) {
			up -= b[i];
			if (a[i] + up < mid) {
				b[i + w] = mid - a[i] - up;
				day += b[i + w];
				up += b[i + w];
			}
		}
		return day <= m;
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
