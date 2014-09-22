import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A7 {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		int k1 = nextInt();
		int k2 = nextInt();
		int roof = Math.max(k1, k2);
		int floor = Math.min(k1, k2);
		// int a[] = new int[n];
		int temp[] = new int[n];
		int start = 0;
		boolean checkMax = false;
		int max = Integer.MIN_VALUE;
		int a[] = new int[n];
		int startMax = -1;
		int maxL = 0;
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
		}
		for (int i = 0; i < n; ++i) {
			if (a[i] > roof) {
				if (checkMax && i - start > maxL) {
					startMax = start;
					maxL = i - start;
					// start = i + 1;

				}
				start = i + 1;
				max = Integer.MIN_VALUE;
				checkMax = false;
			} else if (a[i] > max) {
				max = a[i];
				if (a[i] <= roof && a[i] >= floor) {
					checkMax = true;
				}
			}
		}

		if (checkMax && n - start > maxL) {
			startMax = start;
			maxL = n - start;

		}

		if (startMax == -1) {
			System.out.println(-1);
		} else {
			System.out.println(startMax + " " + maxL);
		}

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
