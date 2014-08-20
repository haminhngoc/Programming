import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TouristProblem {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		long[] a = new long[n];
		long sum = 0;
		for (int i = 0; i < n; ++i) {
			a[i] = nextLong();
			sum += a[i];
		}
		Arrays.sort(a);

		long left = 0;
		long right = sum;
		long numerator = 0;
		for (int i = 0; i < n; ++i) {
			right -= a[i];
			numerator += (-(left - i * a[i]));
			numerator += (right - (n - i - 1) * a[i]);
			numerator += a[i];
			left += a[i];
			//right -= a[i];
		}

		long gcd = GCD(numerator, n);
		System.out.println(numerator / gcd + " " + n / gcd);

		// BigInteger denominator

	}

	static long GCD(long x, long y) {

		long r = x % y;
		while (r > 0) {
			x = y;
			y = r;
			r = x % y;
		}
		return y;
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
