import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MashmokhandNumbers {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		int k = nextInt();

		if (n < 2 && k > 0) {
			System.out.println(-1);
			return;
		}

		if (n / 2 > k) {
			System.out.println(-1);
			return;
		}

		int numberOfCouples = n / 2;
		if (k == 1) {
			if (n == 2) {
				System.out.println("1 2");
			} else {
				System.out.println("1 2 3");
			}
			return;
		}
		if (k == 0 && n == 1) {

			System.out.println(1);
			return;
		}

		int diff = k - (numberOfCouples - 1);

		StringBuilder result = new StringBuilder();
		result.append(diff + " " + diff * 2 + " ");

		n -= 2;
		int i = 1;

		while (true && n >= 2) {
			if (i == diff || i == diff * 2 || i + 1 == diff
					|| i + 1 == 2 * diff) {
				i++;
				continue;
			}

			n -= 2;
			result.append(i + " " + (i + 1) + " ");
			i += 2;
			if (n < 2) {
				break;
			}
		}
		if (n == 1) {
			result.append(200000001);
		}

		System.out.println(result);
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
