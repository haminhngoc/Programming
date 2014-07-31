import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Rewards {

	public static void main(String[] args) throws IOException {
		ReaderRewards reader = new ReaderRewards();
		reader.Init(System.in);
		int a1 = reader.nextInt();
		int a2 = reader.nextInt();
		int a3 = reader.nextInt();
		int b1 = reader.nextInt();
		int b2 = reader.nextInt();
		int b3 = reader.nextInt();
		int n = reader.nextInt();
		int cups = a1 + a2 + a3;
		int medals = b1 + b2 + b3;
		if (cups % 5 == 0) {
			n -= cups / 5;
		} else

		{
			n -= cups / 5 + 1;
		}

		if (medals % 10 == 0) {
			n -= medals / 10;
		} else {
			n -= medals / 10 + 1;
		}
		System.out.println(n >= 0 ? "YES" : "NO");
	}
}

class ReaderRewards {
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