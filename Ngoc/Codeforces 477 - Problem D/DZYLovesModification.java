//import java.util.List;
import java.util.*;

public class DZYLovesModification {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n, m, k, p;
		n = sc.nextInt(); // 10^3
		m = sc.nextInt(); // 10^3
		k = sc.nextInt(); // 10^6
		p = sc.nextInt(); // 100

		long[][] matrix = new long[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		long[] sumRows = new long[n];
		PriorityQueue<Long> queueRow = new PriorityQueue<Long>();
		long adjustRow = 0;

		long[] sumColumns = new long[m];
		PriorityQueue<Long> queueColumn = new PriorityQueue<Long>();
		long adjustColumn = 0;

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

		int result = 0;

		for (; k > 0; k--) {
			long maxRow = -queueRow.peek();
			long maxColumn = -queueColumn.peek();

			if (maxRow - adjustRow > maxColumn - adjustColumn) {
				result += (maxRow - adjustRow);
				maxRow -= m * p;
				adjustColumn += p;
				queueRow.poll();
				queueRow.add(-maxRow);
			} else {
				result += (maxColumn - adjustColumn);
				maxColumn -= n * p;
				adjustRow += p;
				queueColumn.poll();
				queueColumn.add(-maxColumn);
			}
		}

		System.out.println(result);

		/*
		 * for (int i = 0; i < n; i++) { for (int j = 0; j < m; j++) {
		 * System.out.print(matrix[i][j] + ", "); } System.out.println(""); }
		 */
	}
}
