import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PrisonTransfer {

	public static void main(String[] args) throws IOException {
		ReaderPrisonTransfer reader = new ReaderPrisonTransfer();
		ReaderPrisonTransfer.Init(System.in);
		int n = ReaderPrisonTransfer.nextInt(); // 10^5
		long t = ReaderPrisonTransfer.nextLong(); // 10^9
		int c = ReaderPrisonTransfer.nextInt();
		
		long temp;
		long count = 0;
		int countC = 0;
		for (int i = 0; i < n; ++i) {
			temp = ReaderPrisonTransfer.nextLong();
			if (temp <= t) {
				countC++;
				if (countC == c) {
					count++;
					countC--;
				}
			} else {
				countC = 0;
			}
		}
		System.out.println(count);

	}
}

class ReaderPrisonTransfer {
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