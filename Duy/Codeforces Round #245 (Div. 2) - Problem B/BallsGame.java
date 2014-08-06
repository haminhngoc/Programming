import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BallsGame {

	public static void main(String[] args) throws IOException {
		BallsGame main = new BallsGame();
		main.solve();
	}

	void solve() throws IOException {
		ReaderBallsGame reader = new ReaderBallsGame();
		reader.Init(System.in);
		int n = reader.NextInt();
		int k = reader.NextInt();
		int x = reader.NextInt();
		int[] balls = new int[n];
		for (int i = 0; i < n; i++) {
			balls[i] = reader.NextInt();
		}
		int res = 0;
		int max = Integer.MIN_VALUE;
		int temp = 0;
		int currentX = 0;
		for (int i = 0; i < n; i++) {
			if (balls[i] == x) {
				temp = 0;
				res = 0;
				temp++;
				int j = i;
				int l = i - 1;
				currentX = x;
				do {
					if (temp >= 3) {
						res += temp;
						temp = 0;
					}
					for (; j < n; j++) {
						if (balls[j] == currentX) {
							temp++;
						} else {

							break;
						}

					}
					for (; l >= 0; l--) {
						if (balls[l] == currentX) {
							temp++;
						} else {

							break;
						}
					}
					if (l >= 0 && j < n) {
						currentX = balls[j];
					}
				} while (temp >= 3);
				if (res - 1 > max) {
					max = res - 1;
				}
			}
		}
		if (max == -1) {
			max = 0;
		}
		System.out.print(max);
	}
}

class ReaderBallsGame {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String Next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int NextInt() throws IOException {
		return Integer.parseInt(Next());
	}

	static long NextLong() throws IOException {
		return Long.parseLong(Next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(Next());
	}
}