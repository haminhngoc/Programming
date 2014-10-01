import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PashmakAndBuses {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();

		int k = nextInt();
		int d = nextInt();
		StringBuilder result = new StringBuilder();
		if ((k == 1 && n > 1)) {
			System.out.println(-1);
			return;
		} else if (n == 1 && k == 1) {
			for (int i = 0; i < d; ++i) {
				result.append(1 + "\n");
			}

			System.out.print(result);
			return;
		}

		int temp = 1;
		boolean check = false;

		for (int i = 0; i < d; ++i) {
			temp *= k;
			if (temp >= n) {
				check = true;
				break;
			}
		}

		if (!check) {
			System.out.println(-1);
			return;
		}

		if (n == 1) {
			for (int i = 0; i < d; ++i) {
				result.append(1 + "\n");
			}
			System.out.print(result);
			return;
		} else if (k >= n) {
			for (int i = 0; i < d; ++i) {
				for (int j = 0; j < n; ++j) {
					result.append((j + 1) + " ");
				}
				result.append("\n");
			}
			System.out.println(result);
			return;
		}

		for (int i = 0; i < d; ++i) {
			for (int j = 0; j < n; ++j) {
				result.append((((j / temp) + (j % (temp / k))) % k + 1) + " ");
			}
			if (temp != k) {
				temp /= k;
			}
			result.append("\n");
		}

		System.out.print(result);

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
