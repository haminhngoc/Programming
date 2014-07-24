import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LovesModification2 {
	static int n; // 10^3
	static int m; // 10^3
	static int k; // 10^6
	static int p; // 100
	static long[][] a; // n * m
	static long[] sumColumns;
	static long[] sumRows;

	public static void main(String[] args) throws IOException {

		initReader();
		while (true) {
			readInput();

			long result = solve();

			System.out.println(result);

			break;
		}

	}

	public static long solve() {
		PriorityQueue<Long> queueRow = new PriorityQueue<Long>();
		for (int i = 0; i < n; i++) {
			queueRow.add(-sumRows[i]);
		}

		long[] predictSumRows = new long[k + 1];
		for (int i = 1; i < k + 1; i++) {
			long top = -queueRow.poll();
			predictSumRows[i] = predictSumRows[i - 1] + top;
			top -= m * p;
			queueRow.add(-top);
		}

		// //////////////////////////////////////////////////////////

		PriorityQueue<Long> queueColumn = new PriorityQueue<Long>();
		for (int j = 0; j < m; j++) {
			queueColumn.add(-sumColumns[j]);
		}

		long[] predictSumColumns = new long[k + 1];
		for (int j = 1; j < k + 1; j++) {
			long top = -queueColumn.poll();
			predictSumColumns[j] = predictSumColumns[j - 1] + top;
			top -= n * p;
			queueColumn.add(-top);
		}

		// ////////////////////////////////////////////////////////////

		long result = Long.MIN_VALUE;
		for (int i = 0; i <= k; i++) {
			long adjustValue = (long) i * (k - i) * p;
			long value = predictSumColumns[i] + predictSumRows[k - i]
					- adjustValue;
			// System.out.println(i + ": " + predictSumColumns[i] + " + "
			// + predictSumRows[k - i] + " - " + i * (k - i) * p + " = "
			// + value);
			result = Math.max(result, value);
		}
		return result;
	}

	public static void readInput() throws IOException {
		n = nextInt();
		m = nextInt();
		k = nextInt();
		p = nextInt();

		sumRows = new long[n];
		sumColumns = new long[m];
		int item;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				item = nextInt();
				sumRows[i] += item;
				sumColumns[j] += item;
			}
		}
	}

	public static void generateTest() {
		long n = Math.round(100 + Math.random() * 100);
		long m = Math.round(100 + Math.random() * 100);
		long k = Math.round(50000 + Math.random() * 50000);
		long p = 1;

		System.out.println(n + " " + m + " " + k + " " + p);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(Math.round(500 + Math.random() * 500) + " ");
			}
			System.out.println("");
		}
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
