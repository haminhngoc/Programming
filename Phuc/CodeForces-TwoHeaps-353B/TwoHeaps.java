import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoHeaps {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		int end = n + n;
		int[] arr = new int[2 * n];
		int[] count = new int[100];
		for (int i = 0; i < end; ++i) {
			arr[i] = nextInt();
			count[arr[i]]++;
		}
		int[] countC = new int[100];
		int countunique = 0;
		int countR = 0;
		long result = 0;
		for (int i = 10; i < 100; ++i) {
			if (count[i] == 1) {
				countunique++;
			} else if (count[i] > 1) {
				countR++;
			}
		}

		int right;
		int left;
		left = countunique / 2;
		right = countunique - left;
		result = (left + countR) * (right + countR);
		System.out.println(result);
		StringBuilder temp = new StringBuilder();
		int remaining = n - left - countR;
		for (int i = 0; i < end; ++i) {
			if (count[arr[i]] == 0) {
				continue;
			}
			if (count[arr[i]] == 1) {
				if (left > 0) {
					// System.out.print(1 + " ");
					temp.append(1 + " ");
					left--;
				} else {
					// System.out.print(2 + " ");
					temp.append(2 + " ");
				}

			} else {
				if (countC[arr[i]] == 0
						|| (countC[arr[i]] < count[arr[i]] - 1 && remaining > 0)) {
					temp.append(1 + " ");
					if (countC[arr[i]] != 0) {
						remaining--;
					}

					countC[arr[i]]++;

				} else {
					temp.append(2 + " ");
				}
			}
		}
		System.out.println(temp);
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

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
}
