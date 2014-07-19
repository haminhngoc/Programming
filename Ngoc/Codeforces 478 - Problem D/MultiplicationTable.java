import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MultiplicationTable {
	static int n; // 500K
	static int m; // 500K
	static int k; // n * m

	static int upperStart;
	static int upperEnd;
	static int[] upperBoundIndex;
	static int upperCount;

	static int lowerStart;
	static int lowerEnd;
	static int[] lowerBoundIndex;
	static int[] lowerCount;

	public static void main(String[] args) throws IOException {
		initReader();
		while (true) {
			readInput();

			int result = solve();

			System.out.println(result);

			// break;
		}

	}

	public static int solve() {
		if (m < n) {
			int temp = m;
			m = n;
			n = temp;
		}
		upperBoundIndex = new int[m];
		upperBoundIndex = new int[m];

		while (true) {
			break;
		}

		return 0;
	}

	public static void readInput() throws IOException {
		n = nextInt();
		m = nextInt();
		k = nextInt();
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
