import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FedyaAndMaths {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		String n = next();
		int start = n.length() <= 2 ? 0 : n.length() - 2;
		int temp = Integer.parseInt(n.substring(start));
		if (temp % 4 == 0) {
			System.out.println(4);
		} else {
			System.out.println(0);
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
}
