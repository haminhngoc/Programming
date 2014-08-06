import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheChildandToy {

	public static void main(String[] args) throws IOException {
		ReaderTheChildandToy reader = new ReaderTheChildandToy();
		reader.Init(System.in);
		int n = reader.nextInt(); // 1000
		int m = reader.nextInt(); // 2000

		int[] value = new int[n + 1];
		int[] sum = new int[n + 1];
		boolean[][] arr = new boolean[n + 1][n + 1];
		int[] count = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			value[i] = reader.nextInt();

		}
		int x;
		int y;
		for (int i = 0; i < m; ++i) {
			x = reader.nextInt();
			y = reader.nextInt();
			arr[x][y] = true;
			arr[y][x] = true;
			sum[x] += value[y];
			sum[y] += value[x];
			count[x]++;
			count[y]++;
		}

		int left = n;
		long max;
		int currentNOde = 0;
		long result = 0;
		while (left > 0) {
			max = Long.MAX_VALUE;
			for (int i = 1; i <= n; ++i) {
				if (max >= sum[i] && value[i] != 0) {
					if (max == sum[i]
							&& value[i] * count[i] >= value[currentNOde]
									* count[currentNOde]) {
						if (value[i] * count[i] == value[currentNOde]
								* count[currentNOde]
								&& count[i] > count[currentNOde]) {
							currentNOde = i;
							max = sum[i];
							continue;
						} else if (value[i] * count[i] > value[currentNOde]
								* count[currentNOde]) {
							currentNOde = i;
							max = sum[i];
						}

					}

					else if (max > sum[i]) {
						currentNOde = i;
						max = sum[i];
					}
				}
			}

			for (int i = 1; i <= n; ++i) {
				if (arr[i][currentNOde]) {
					sum[i] -= value[currentNOde];
					arr[i][currentNOde] = false;
					arr[currentNOde][i] = false;
				}
			}
			
			result += sum[currentNOde];
			sum[currentNOde] = 0;
			value[currentNOde] = 0;
			left--;
		}
		System.out.println(result);

	}
}

class ReaderTheChildandToy {
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