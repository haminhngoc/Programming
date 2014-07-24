import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JzzhuandChocolate {

	public static void main(String[] args) throws IOException {
		JzzhuandChocolate main = new JzzhuandChocolate();
		main.solve();
	}

	void solve() throws IOException {
		ReaderJzzhuandChocolate reader = new ReaderJzzhuandChocolate();
		reader.Init(System.in);
		long n = reader.NextLong();
		long m = reader.NextLong();
		long k = reader.NextLong();
		long res = 0;
		long smallest = 0;

		if (k > m + n - 2) {
			System.out.print(-1);
			return;
		}
		long temp = 0;
		long tempRes = 0;
		for (int i = 0; i < 2; i++) {
			if (k <= m - 1) {
				tempRes = n * (m / (k + 1));
			} else {
				tempRes = n / (k - (m -1) + 1);
			}
			temp = n;
			n = m;
			m = temp;
			res = Math.max(res, tempRes);
		}
		System.out.print(res);
	}
}

class ReaderJzzhuandChocolate {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String Next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int NextInt() throws IOException {
		return Integer.parseInt(Next());
	}

	static long NextLong() throws IOException {
		return Long.parseLong(Next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(Next());
	}
}