import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Divisors {
	static long X; // 10^12
	static long k; // 10^18
	static long[] divisorIndex;
	static long[] divisors;

	public static void main(String[] args) throws IOException {
		initReader();
		while (true) {
			readInput();

			int result = solve();

			System.out.println(result);

			break;
		}

	}

	public static int solve() {

		return 0;
	}

	public static void Fatorization() {
		long sq = Math.round(Math.sqrt(X)); // 10 ^ 6
		long x = X;
		divisorIndex[0] = 1;
		long i = 2;
		while (i < sq) {
			if (x % i == 0) {
				x = x / i;
			} else {
				i++;
			}
		}
	}

	public static void readInput() throws IOException {
		X = nextLong();
		k = nextLong();
	}

	static BufferedReader reader;
	static StringTokenizer tokenizer;

	public static void initReader() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static String nextLine() throws IOException {
		return reader.readLine();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static Double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
