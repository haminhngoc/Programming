import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A4 {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
		}

		int preLength = -1;
		int tempStart = 0;
		int maxL = 0;
		int startMax = -1;
		if (n == 1) {
			System.out.println("0 1");
			return;
		} else if (n == 0) {
			System.out.println("-1");
			return;
		}
		int i;
		for (i = 1; i < n; ++i) {
			if (a[i] < a[i - 1]) {

				if (preLength == -1) {
					preLength = i;
					maxL = i - tempStart;
					startMax = 0;
				} else {

					if (preLength == 1) {
						int newL = i - tempStart + 1;
						if (newL > maxL) {
							maxL = newL;
							startMax = tempStart - 1;
						}
					} else if (i - tempStart == 1) {
						int newL = preLength + 1;

						if (newL > maxL) {
							maxL = newL;
							startMax = i - newL;
						}
					} else {
						int newL = i - tempStart;
						if (a[tempStart - 2] <= a[tempStart]
								|| a[tempStart - 1] <= a[tempStart + 1]) {
							if (preLength + newL > maxL) {
								maxL = preLength + newL;
								startMax = tempStart - preLength;
							}

						}
						if (newL >= maxL) {
							maxL = newL + 1;
							startMax = tempStart - 1;
						}
					}

					preLength = i - tempStart;
				}

				tempStart = i;
			}

		}

		if (preLength == -1) {
			preLength = i;
			maxL = i - tempStart;
			startMax = 0;
		} else {

			if (preLength == 1) {
				int newL = i - tempStart + 1;
				if (newL > maxL) {
					maxL = newL;
					startMax = tempStart - 1;
				}
			} else if (i - tempStart == 1) {
				int newL = preLength + 1;

				if (newL > maxL) {
					maxL = newL;
					startMax = i - newL;
				}
			} else {
				int newL = i - tempStart;
				if (a[tempStart - 2] <= a[tempStart]
						|| a[tempStart - 1] <= a[tempStart + 1]) {
					if (preLength + newL > maxL) {
						maxL = preLength + newL;
						startMax = tempStart - preLength;
					}

				}
				if (newL >= maxL) {
					maxL = newL + 1;
					startMax = tempStart - 1;
				}

			}
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
