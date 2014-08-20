import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boredom {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		int temp;
		long a[] = new long[(int) (1e5 + 1)];
		for (int i = 0; i < n; ++i) {
			temp = nextInt();
			a[temp] += temp;
		}
		for (int i = 2; i <= 100000; ++i) {
			a[i] = Math.max(a[i - 2] + a[i], a[i - 1]);
		}

		System.out.println(a[100000]);
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
