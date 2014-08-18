import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JzzhuandChildren {

	public static void main(String[] args) throws IOException {
		ReaderJzzhuandChildren reader = new ReaderJzzhuandChildren();
		reader.Init(System.in);
		int n = reader.nextInt();
		int m = reader.nextInt();
		int postion = -1;
		int max = 0;
		int temp;
		for (int i = 1; i <= n; ++i) {
			temp = reader.nextInt();
			temp = temp % m == 0 ? temp / m : temp / m + 1;
			if (temp >= max) {
				max = temp;
				postion = i;
			}
		}

		System.out.println(postion);

	}
}

class ReaderJzzhuandChildren {
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