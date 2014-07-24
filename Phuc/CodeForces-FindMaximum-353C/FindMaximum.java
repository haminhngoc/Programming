import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindMaximum {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
		}
		char t;

		char[] m = next().toCharArray();

		for (int i = 0; i < n / 2; ++i) {
			t = m[i];
			m[i] = m[n - 1 - i];
			m[n - 1 - i] = t;
		}
		for (int i = 0; i < n / 2; ++i) {
			int ta = a[i];
			a[i] = a[n - 1 - i];
			a[n - 1 - i] = ta;
		}
		int start = -1;
		for (int i = 0; i < n; ++i) {
			if (m[i] == '1') {
				start = i;
				break;
			}
		}
		if (start == -1) {
			System.out.println(0);
			return;
		}

		long[] sum = new long[n];
		sum[0] = a[0];
		for (int i = 1; i < n; ++i) {
			sum[i] = sum[i - 1] + a[i];
		}

		long max = Long.MIN_VALUE;
		long tempSum = 0;
		boolean allOne = true;
		for (int i = start; i < n; ++i) {
			if (m[i] == '0') {
				allOne = false;
				continue;
			}
			tempSum += a[i];
		}

		long maxSum = sum[n - 1];
		max = tempSum;
		long temp = 0;
		if (!allOne) {
			for (int i = start; i < n; ++i) {
				if (m[i] == '1') {
					if (temp + maxSum - sum[i] > max) {
						max = temp + maxSum - sum[i];
					}
					temp += a[i];
				}
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

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
}
