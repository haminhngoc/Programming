import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A8 {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		int a[] = new int[n];
		int k = nextInt();
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
		}

		if (k < 0) {
			System.out.println(-1);
			return;
		}

		int minPos = 0;
		int maxPos = 0;
		int startMax = 0;
		int maxL = 0;
		int start = 0;
		for (int i = 0; i < n; ++i) {
			if (a[i] > a[maxPos]) {
				maxPos = i;
				if (a[maxPos] - a[minPos] > k) {
					if (maxPos - start > maxL) {
						maxL = maxPos - start;
						startMax = start;
					}
					minPos = maxPos;
					int j;
					for (j = maxPos - 1; j > start; --j) {
						if (a[maxPos] - a[j] > k) {
							break;
						}
						if (a[j] < a[minPos]) {
							minPos = j;
						}
					}
					start = j + 1;
				}
			} else if (a[i] < a[minPos]) {
				minPos = i;
				if (a[maxPos] - a[minPos] > k) {
					if (minPos - start > maxL) {
						maxL = minPos - start;
						startMax = start;
					}
					maxPos = minPos;
					int j;
					for (j = minPos - 1; j > start; --j) {
						if (a[j] - a[minPos] > k) {
							break;
						}
						if (a[j] > a[maxPos]) {
							maxPos = j;
						}
					}

					start = j + 1;
				}
			}
		}
		if (n - start > maxL) {
			startMax = start;
			maxL = n - start;
		}

		System.out.println(startMax + " " + maxL);

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
