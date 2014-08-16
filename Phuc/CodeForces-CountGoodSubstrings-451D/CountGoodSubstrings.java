import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CountGoodSubstrings {

	public static void main(String[] args) throws IOException {

		Init(System.in);

		char[] arr = next().toCharArray();
		int n = arr.length;
		int codeOfa = 'a';
		int[][] count = new int[2][2];
		for (int i = 0; i < n; ++i) {
			count[arr[i] - codeOfa][i % 2]++;
		}
		long countEven = 0;
		long countOdd = 0;

		for (int i = 0; i < n; ++i) {
			if (i % 2 == 0) {
				countEven += count[arr[i] - codeOfa][1];
				countOdd += count[arr[i] - codeOfa][0];
				count[arr[i] - codeOfa][0]--;
			} else {
				countEven += count[arr[i] - codeOfa][0];
				countOdd += count[arr[i] - codeOfa][1];
				count[arr[i] - codeOfa][1]--;
			}
		}
		System.out.println(countEven + " " + countOdd);
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

}
