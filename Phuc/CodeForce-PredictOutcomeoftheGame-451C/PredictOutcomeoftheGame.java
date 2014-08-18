import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PredictOutcomeoftheGame {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int t = nextInt();
		long n, k, d1, d2;
		for (int i = 0; i < t; ++i) {
			n = nextLong();
			k = nextLong();
			d1 = nextLong();
			d2 = nextLong();
			System.out.println(solve(n, k, d1, d2));
		}

	}

	private static String solve(long n, long k, long d1, long d2) {

		if (n % 3 != 0) {
			return "no";
		}
		if (k == 0) {
			return "yes";
		}
		// win1>win2, win2 >win3

		long sum = k + d1 + d2;
		long win1, win2, win3;
		if ((k - d1 + d2) % 3 == 0) {
			win2 = (k - d1 + d2) / 3;
			win1 = d1 + win2;
			win3 = win2 - d2;
			if (!(win1 < win2 || win2 < win3 || win1 < 0 || win2 < 0 || win3 < 0)) {
				if (n - k >= 2 * d1 + d2) {
					return "yes";
				}
			}
		}
		if (sum % 3 == 0) {
			win2 = sum / 3;
			win1 = win2 - d1;
			win3 = win2 - d2;
			if (!(win1 > win2 || win3 > win2 || win1 < 0 || win2 < 0 || win3 < 0)) {
				if (n - k >= d1 + d2) {
					return "yes";
				}
			}
		}
		if ((k - d1 - d2) % 3 == 0) {
			win2 = (k - d1 - d2) / 3;
			win1 = d1 + win2;
			win3 = d2 + win2;
			if (!(win2 > win1 || win2 > win3 || win1 < 0 || win2 < 0 || win3 < 0)) {
				if (n - k >= d2 * 2 - d1 && d1 <= d2) {
					return "yes";
				}
				if (n - k >= d1 * 2 - d2 && d2 <= d1) {
					return "yes";
				}
			}
		}
		if ((k - d2 + d1) % 3 == 0) {
			win2 = (k - d2 + d1) / 3;
			win3 = d2 + win2;
			win1 = win2 - d1;
			if (!(win2 < win1 || win3 < win2 || win1 < 0 || win2 < 0 || win3 < 0)) {
				if (n - k >= 2 * d2 + d1) {
					return "yes";
				}
			}
		}
		return "no";
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

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
}
