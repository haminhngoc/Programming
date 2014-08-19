import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LittlePonyandExpectedMaximum {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int m = nextInt();
		int n = nextInt();

		double result = 0;
		int j = m;
		double temp;
		double t = 1;

		for (int i = 1; i <= m; ++i) {
			temp = Math.pow(((double) (j - 1)) / (double) m, n);
			// sum += temp;
			result += j * (t - temp);
			j--;
			t = temp;
		}
		System.out.println(result);

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
