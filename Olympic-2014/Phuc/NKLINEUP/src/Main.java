import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		int q = nextInt();
		int a[] = new int[n];

		int max[] = new int[300];
		Arrays.fill(max, Integer.MIN_VALUE);
		int min[] = new int[300];
		Arrays.fill(min, Integer.MAX_VALUE);
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
			int z = i / 250;
			if (a[i] < min[z]) {
				min[z] = a[i];
			}
			if (a[i] > max[z]) {
				max[z] = a[i];
			}
		}

		StringBuilder str = new StringBuilder();
		for (int i = 0; i < q; ++i) {
			int z = nextInt();
			int b = nextInt();

			str.append(exe(z - 1, b - 1, max, min, a));
			str.append("\n");
		}

		System.out.println(str);
	}

	private static Integer exe(int a, int b, int[] max, int[] min, int[] arr) {
		int z = a / 250;
		int y = b / 250;
		int m = Integer.MIN_VALUE;
		int n = Integer.MAX_VALUE;
		for (int i = z + 1; i < y; ++i) {
			if (max[i] > m) {
				m = max[i];
			}
			if (min[i] < n) {
				n = min[i];
			}
		}
		int end = z * 250 + 249;
		for (int i = a; i <= end && i <= b; ++i) {
			if (arr[i] > m) {
				m = arr[i];
			}
			if (arr[i] < n) {
				n = arr[i];
			}
		}
		if (z == y) {
			return m - n;
		}
		end = y * 250 - 250;
		for (int i = b; i > end && i >= a; --i) {
			if (arr[i] > m) {
				m = arr[i];
			}
			if (arr[i] < n) {
				n = arr[i];
			}
		}

		return m - n;
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
