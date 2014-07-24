import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrisonTransfer {

	public static void main(String[] args) throws IOException {
		PrisonTransfer main = new PrisonTransfer();
		main.solve();
	}

	void solve() throws IOException {
		ReaderPrisonTransfer reader = new ReaderPrisonTransfer();
		reader.Init(System.in);
		int n = reader.NextInt();
		int t = reader.NextInt();
		int c = reader.NextInt();
		//int[] prisoners = new int[n];
		int prisoner =0;
		int count = 0;
		int res = 0;
		for (int i = 0; i < n; i++) {
			prisoner = reader.NextInt();
			if (prisoner <= t) {
				count++;
			} else {
				count = 0;
			}
			if (count == c) {
				res++;
				count--;
			}
		}

		System.out.print(res);
	}

}

class ReaderPrisonTransfer {
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