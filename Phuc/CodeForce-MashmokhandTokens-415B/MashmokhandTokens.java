import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MashmokhandTokens {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		long a = nextInt();
		long b = nextInt();
		StringBuilder result = new StringBuilder();
		long temp;
		long tempR;
		for (int i = 0; i < n; ++i) {
			temp = nextInt();
			// tempR = temp - (temp * a / b) * b / a;
			tempR = (temp * a / b) * b;
			if (tempR % a == 0) {
				tempR = temp - tempR / a;
			} else {
				tempR = temp - tempR / a - 1;
			}
			result.append(tempR + " ");
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
