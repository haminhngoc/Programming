import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ShowerLine {

	public static void main(String[] args) throws IOException {
		ReaderShowerLine reader = new ReaderShowerLine();
		reader.Init(System.in);

		int[][] arr = new int[5][5];
		long max = Long.MIN_VALUE;
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				arr[i][j] = reader.nextInt();
			}
		}

		long temp = 0;
		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 5; ++j) {
				if (j == i) {
					continue;
				}
				for (int k = 0; k < 5; ++k) {
					if (k == i || k == j) {
						continue;
					}
					for (int h = 0; h < 5; ++h) {
						if (k == h || h == j || h == i) {
							continue;
						}
						for (int t = 0; t < 5; ++t) {
							if (t == h || t == j || t == i || t == k) {
								continue;
							}
							temp =0;
							temp += arr[i][j] + arr[j][i] + arr[k][h]
									+ arr[h][k];
							temp += arr[j][k] + arr[k][j] + arr[h][t]
									+ arr[t][h];
							temp += arr[k][h] + arr[h][k];
							temp += arr[h][t] + arr[t][h];

							if (temp > max) {
								max = temp;
							}
						}
					}
				}
			}
		}
		System.out.println(max);

	}
}

class ReaderShowerLine {
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