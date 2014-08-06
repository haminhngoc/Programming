import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BallsGame {

	public static void main(String[] args) throws IOException {
		ReaderBallsGame reader = new ReaderBallsGame();
		reader.Init(System.in);

		int n = reader.nextInt(); // 100
		int k = reader.nextInt();
		int x = reader.nextInt();

		int max = 0;
		int[] balls = new int[n];
		for (int i = 0; i < n; ++i) {
			balls[i] = reader.nextInt();
		}

		int end = n - 2;
		int index;
		int color;
		int count;
		for (int i = 1; i < end; ++i) {
			if (balls[i] == balls[i + 1] && balls[i] == x) {
				index = i - 1;
				while (i < n - 1 && balls[i] == balls[i + 1]) {
					i++;
				}
				count = i - index;
				if (i == n - 1) {
					max = count > max ? count : max;
					break;
				}
				int j = i + 1;
				while (index >= 0
						&& j < n
						&& balls[index] == balls[j]
						&& ((index - 1 >= 0 && balls[index - 1] == balls[index]) || (j + 1 < n && balls[j + 1] == balls[j]))) {
					color = balls[index];
					while (index >= 0 && balls[index] == color) {
						count++;
						index--;
					}
					while (j < n && balls[j] == color) {
						count++;
						j++;
					}
				}

				max = count > max ? count : max;
			}

		}
		System.out.println(max);

	}
}

class ReaderBallsGame {
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