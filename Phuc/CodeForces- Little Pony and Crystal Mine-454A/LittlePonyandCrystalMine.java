import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LittlePonyandCrystalMine {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		char[][] result = new char[n][n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(result[i], '*');
		}

		int count = 0;
		int mid = n / 2;
		int i;
		for (i = 0; i <= mid; ++i) {
			int end = mid + count + 1;
			for (int j = mid - count; j < end; ++j) {
				result[i][j] = 'D';
			}
			count++;
		}
		count -= 2;
		for (; i < n; ++i) {
			int end = mid + count + 1;
			for (int j = mid - count; j < end; ++j) {
				result[i][j] = 'D';
			}
			count--;
		}

		for (i = 0; i < n; ++i) {
			String s = new String(result[i]);
			System.out.println(s);
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

	static Double NextDouble() throws IOException {
		return Double.parseDouble(next());
	}

}
