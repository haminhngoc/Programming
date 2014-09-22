import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MalekDanceClub {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		// Init(System.in);
		char x[] = next().toCharArray();
		int n = x.length;
		final int CODE0 = '0';
		long result = 0;
		int end = n - 1;
		final int MOD = 1000000007;
		int temp;
		int k;
		int p;
		for (int i = 1; i < end; ++i) {
			k = 1;
			p = n - 1;
			temp = i;
			while (temp > 0) {
				temp = k & i;
				if ((temp > 0 && x[p] == '0') || (temp == 0) && x[p] == 1) {
					result += k;
					k *= 2;
					p--;
					result %= MOD;
				}
			}
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
