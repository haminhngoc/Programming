import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JzzhuandSequences {

	public static void main(String[] args) throws IOException {

		ReaderJzzhuandSequences reader = new ReaderJzzhuandSequences();
		reader.Init(System.in);
		long x = reader.nextLong();
		long y = reader.nextLong();
		long n = reader.nextLong();
		long result = 0;
		if (n % 3 == 1 && n % 6 == 4) {
			result = -x;
		} else if (n % 3 == 1 && n % 6 == 1) {
			result = x;
		} else if (n % 3 == 2 && n % 6 == 2) {
			result = y;
		} else if (n % 3 == 2 && n % 6 == 5) {
			result = -y;
		} else if (n % 3 == 0 && n % 6 == 0) {
			result = x - y;
		} else if (n % 3 == 0 && n % 6 == 3) {
			result = y - x;
		}
		while (result < 0) {
			result += 1000000007;
		}
		System.out.println(result % 1000000007);
	}
}

class ReaderJzzhuandSequences {
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