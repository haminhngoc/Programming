import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import sun.net.www.content.audio.basic;

public class PingPong {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		Interval[] arr = new Interval[n];
		int count = 0;
		int[][] a = new int[n][n];
		StringBuilder temp = new StringBuilder();
		int type;
		for (int i = 0; i < n; ++i) {
			type = nextInt();
			if (type == 1) {
				arr[count] = new Interval();
				arr[count].a = nextInt();
				arr[count].b = nextInt();
				for (int j = 0; j < count; ++j) {
					if ((arr[j].b < arr[count].b && arr[j].b > arr[count].a)
							|| (arr[j].a < arr[count].b && arr[j].a > arr[count].a)) {
						a[j][count] = 1;

					}

					if ((arr[count].b < arr[j].b && arr[count].b > arr[j].a)
							|| (arr[count].a < arr[j].b && arr[count].a > arr[j].a)) {
						a[count][j] = 1;

					}
				}
				count++;
			} else {
				int x = nextInt();
				int y = nextInt();
				temp.append(check(x - 1, y - 1, a, count) ? "YES\n" : "NO\n");
			}
		}
		System.out.print(temp);

	}

	public static boolean check(int s, int end, int[][] a, int count) {
		boolean check[] = new boolean[count];
		check[s] = true;

		return dfs(s, end, a, check, count);

	}

	private static boolean dfs(int s, int end, int[][] a, boolean[] check,
			int count) {
		for (int i = 0; i < count; ++i) {
			if (i == s || check[i]) {
				continue;
			}
			if (a[s][i] == 1) {
				check[s] = true;
				if (i == end) {
					return true;
				}
				if (dfs(i, end, a, check, count)) {
					return true;
				}
			}

		}
		return false;

	}

	static public class Interval {
		int a;
		int b;
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
