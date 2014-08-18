import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KTree {

	public static void main(String[] args) throws IOException {

		Init(System.in);
		int n = nextInt();
		int k = nextInt();
		int d = nextInt();

		/*
		 * int[][] combinations = new int[101][101];
		 * 
		 * int temp = 1; int end; for (int i = 1; i <= 100; ++i) {
		 * combinations[i][0] = 1; end = i / 2; combinations[i][i] = 1; for (int
		 * j = 1; j <= end; ++j) {
		 * 
		 * combinations[i][j] = (int) (combinations[i][j - 1] (long) (i - j + 1)
		 * / j) % 1000000007; combinations[i][i - j] = combinations[i][j]; } }
		 * int[][][] arr = new int[k + 1][n + 1][n + 1]; //
		 * number-numbercount-sum
		 * 
		 * for (int i = 0; i <= n; ++i) { for (int j = 0; j <= n; ++j) { if (i
		 * == j) { arr[1][i][j] = 1; } else { arr[1][i][j] = 0; } } }
		 * 
		 * for (int i = 2; i <= k; ++i) { arr[i][0][0] = 1; for (int j = 1; j <=
		 * n; j++) { for (int z = 1; z <= n; z++) { temp = 1; arr[i][j][z] =
		 * arr[i - 1][j][z]; while (temp * i <= z && j >= temp) { arr[i][j][z]
		 * += (long) combinations[j][temp] arr[i - 1][j - temp][z - temp * i] %
		 * 1000000007; arr[i][j][z] %= 1000000007; temp++; } } } }
		 * 
		 * long result = 0; for (int i = 0; i <= n; ++i) { result +=
		 * arr[k][i][n]; result %= (1e9+7); } if (d > 1) { for (int i = 0; i <=
		 * n; ++i) { result -= arr[d - 1][i][n]; result %= 1000000007; } }
		 * 
		 * if (result < 0) { result += 1000000007; }
		 */

		long result = 0;
		long[] included = new long[n + 1];
		long[] excluded = new long[n + 1];

		included[1] = (d == 1 ? 1 : 0);
		excluded[1] = (d == 1 ? 0 : 1);
		long temp1 = 0;
		long temp2;
		for (int i = 2; i <= n; ++i) {
			if (d <= i && i <= k) {
				temp1 = 1;
			} else {
				temp1 = 0;
			}

			temp2 = i < d ? 1 : 0;

			for (int j = 1; j < i && j <= k; ++j) {
				if (j < d) {
					temp1 += included[i - j];
					temp2 += excluded[i - j];
				} else {
					temp1 += included[i - j];
					temp1 += excluded[i - j];
				}
			}
			included[i] = (long) (temp1 % (1e9 + 7));
			excluded[i] = (long) (temp2 % (1e9 + 7));
		}
		System.out.println(included[n]);
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
