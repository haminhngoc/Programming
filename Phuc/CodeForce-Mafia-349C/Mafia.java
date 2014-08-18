import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mafia {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		int[] arr = new int[n + 1];
		long sum = 0;
		long max = Long.MIN_VALUE;
		for (int i = 1; i <= n; ++i) {
			arr[i] = nextInt();
			sum += arr[i];
			max = max < arr[i] ? arr[i] : max;
		}
		if (sum % (n - 1) == 0) {
			System.out.println(sum / (n - 1) > max ? sum / (n - 1) : max);
		} else {
			System.out.println(sum / (n - 1) + 1 > max ? sum / (n - 1) + 1
					: max);
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
