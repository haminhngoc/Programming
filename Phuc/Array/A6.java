import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A6 {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();

		int a[] = new int[n];
		int temp[] = new int[n];

		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
			temp[i] = a[i] + (i > 0 ? temp[i - 1] : 0);
		}
		long max = Long.MIN_VALUE;
		long adjust = 0;
		int start = 0;
		int end = 0;
		int adjustIndex = -1;
		for (int i = 0; i < n; ++i) {
			if (temp[i] - adjust > max) {
				max = temp[i] - adjust;
				start = adjustIndex + 1;
				end = i;
			}
			if (temp[i] < adjust) {
				adjust = temp[i];
				adjustIndex = i;
			}
		}

		System.out.println(start + " " + end);

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
