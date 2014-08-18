import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SerejaAndMirroring {

	public static void main(String[] args) throws IOException {
		ReaderSerejaAndMirroring reader = new ReaderSerejaAndMirroring();
		reader.Init(System.in);
		int n = reader.nextInt(); // 100
		int m = reader.nextInt();// 100
		int[][] a = new int[n][m];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				a[i][j] = reader.nextInt();
			}
		}
		boolean identical = true;
		while (n % 2 == 0) {
			n = n / 2;
			identical = true;
			for (int i = 0; i < n; ++i) {
				for (int j = 0; j < m; ++j) {
					if (a[i][j] != a[2 * n - 1 - i][j]) {
						identical = false;
						break;
					}
				}
				if (!identical) {
					break;
				}
			}
			if (!identical) {
				System.out.println(2 * n);
				return;
			}
		}

		System.out.println(n);
		return;

	}

}

class ReaderSerejaAndMirroring {
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