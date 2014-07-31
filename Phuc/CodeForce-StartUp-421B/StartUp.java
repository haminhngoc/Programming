import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartUp {

	public static void main(String[] args) throws IOException {
		ReaderStartUp reader = new ReaderStartUp();
		reader.Init(System.in);
		char[] posible = new char[] { 'A', 'H', 'I', 'M', 'O', 'U', 'V', 'W',
				'T', 'X', 'Y' };
		char[] input = reader.next().toCharArray();
		int inputLength = input.length;
		int posibleLength = posible.length;
		int j;
		for (int i = 0; i <= inputLength / 2; ++i) {
			for (j = 0; j < posibleLength; ++j) {
				if (input[i] == posible[j]) {
					break;
				}

			}
			if (j >= posibleLength || input[i] != input[inputLength - 1 - i]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		
	}

}

class ReaderStartUp {
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