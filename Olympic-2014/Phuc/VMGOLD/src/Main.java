import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		int k = nextInt();

		long has[][] = new long[n + 1][k + 1];
		long no[][] = new long[n + 1][k + 1];

		for (int i = 0; i < n; ++i) {
			long t = nextLong();
			has[i][1] = t;
			no[i][1] =1;
			for (int j = 2; j <= k; ++j) {
				has[i][j] = 1;
				for (int z = 0; z < i; ++z) {

					if (has[z][j - 1] != 0) {
						has[i][j] = Math.max(has[i][j], gcd(t, has[z][j - 1]));
					}
					if (no[z][j - 1] != 0) {
						has[i][j] = Math.max(has[i][j], gcd(t, no[z][j - 1]));
						no[i][j] = Math.max(no[i][j], has[z][j]);
						no[i][j] = Math.max(has[z][j], no[z][j]);
					}
				}
			}

			
		}
		System.out.println(Math.max(has[n][k], no[n][k]));

	}

	static long gcd(long x, long y) {
		if (x % y == 0) {
			return y;
		}
		return gcd(y, x % y);
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
