import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PashaMaximizes {

	public static void main(String[] args) throws IOException {
		ReaderPashaMaximizes reader = new ReaderPashaMaximizes();
		reader.Init(System.in);
		char[] input = reader.next().toCharArray();
		int k = reader.nextInt();
		char tempChar;
		int position;
		int inputLength = input.length;
		for (int i = 0; i<inputLength; ++i) {
			tempChar = input[i];
			position = i;
			for (int j = i + 1; j < inputLength&&(j-i<=k); ++j) {
				if (input[j] > tempChar) {
					tempChar = input[j];
					position = j;
				}
			}
			if (i == position) {
				continue;
			}
			for (int j = position - 1; j >= i; j--) {
				input[j + 1] = input[j];
				k--;
			}
			input[i] = tempChar;
			if(k==0){
				break;
			}
		}
		for (int i = 0; i < inputLength; ++i) {
			System.out.print(input[i]);
		}
		System.out.println();

	}
}

class ReaderPashaMaximizes {
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