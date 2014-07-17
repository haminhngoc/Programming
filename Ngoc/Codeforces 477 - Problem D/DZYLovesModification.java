import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class DZYLovesModification {

	public static void main(String[] args) throws IOException {
		ReaderModification.Init(System.in);
		int n, m, k, p;
		n = ReaderModification.nextInt(); // 10^3
		m = ReaderModification.nextInt(); // 10^3
		k = ReaderModification.nextInt(); // 10^6
		p = ReaderModification.nextInt(); // 100

		long[][] matrix = new long[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = ReaderModification.nextInt();
			}
		}

		long[] sumRows = new long[n];
		PriorityQueue<Long> queueRow = new PriorityQueue<Long>();

		long[] sumColumns = new long[m];
		PriorityQueue<Long> queueColumn = new PriorityQueue<Long>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sumRows[i] += matrix[i][j];
				sumColumns[j] += matrix[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			queueRow.add(-sumRows[i]);
		}

		for (int j = 0; j < m; j++) {
			queueColumn.add(-sumColumns[j]);
		}

		long[] predictRowValue = new long[k + 1];
		long[] predictColumnValue = new long[k + 1];
		long headRow, headColumn;
		for (int i = 1; i <= k; i++) {
			headRow = -queueRow.poll();
			predictRowValue[i] = headRow + predictRowValue[i - 1];
			headRow -= m * p;
			queueRow.add(-headRow);

			headColumn = -queueColumn.poll();
			predictColumnValue[i] = headColumn + predictColumnValue[i - 1];
			headColumn -= n * p;
			queueColumn.add(-headColumn);
		}

		long result = predictRowValue[0] + predictColumnValue[k];
		for (int i = 0; i <= k; i++) {
			long adjustValue = i * (k - i) * p;
			long currentValue = predictRowValue[i] + predictColumnValue[k - i]
					- adjustValue;
			if (k > 1000) {
				System.out.println(predictRowValue[i] + " "
						+ predictColumnValue[k - i]);
			}
			if (currentValue >= result) {				
				result = currentValue;
			}
		}
		System.out.println(result);
	}
}

class ReaderModification {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String Next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(Next());
	}

	static long NextLong() throws IOException {
		return Long.parseLong(Next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(Next());
	}
}
