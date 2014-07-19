import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MultiplicationTable {
	static int n; // 500K
	static int m; // 500K
	static int k; // n * m

	static int[] lowPartition;
	static int[] upPartition;

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
		k = m * n - k;
		// int lowPartitionCount = 1;
		lowPartition = new int[m + 2];
		lowPartition[0] = 1;

		// int upPartitionCount = 1;
		upPartition = new int[m + 2];
		for (int i = 0; i < m; i++) {
			upPartition[i] = 0;
		}
		upPartition[m] = n;
		upPartition[m + 1] = m + 1;

		int[] partition = new int[m + 2];

		while (true) {

			int validCount = 0;
			for (int i = 1; i <= m; i++) {
				if (upPartition[i] > lowPartition[i] + 1) {
					validCount++;
					partition[i] = (upPartition[i] - lowPartition[i]) / 2;
				}
			}
			if (validCount > 0) {
				validCount = (validCount + 1) / 2;
				int columnPivot = 1;
				for (int i = 1; i <= m; i++) {
					if (upPartition[i] > lowPartition[i] + 1)
						validCount--;
					if (validCount == 0) {
						columnPivot = i;
						break;
					}
				}

				int partitionCount = makePartition(partition, columnPivot);
				if (k < partitionCount) {
					upPartition = partition;
				} else {
					lowPartition = partition;
				}
			} else {
				List<Integer> inPartition = new ArrayList<Integer>();
				//LATER				
			}

			break;
		}

		return 0;
	}

	public static int makePartition(int[] partition, int columnPivot) {

		int maxItem = columnPivot * partition[columnPivot];
		int partitionCount = columnPivot * partition[columnPivot];
		for (int i = columnPivot + 1; i < m; i++) {
			int j = partition[columnPivot];
			for (; j >= 1; j--) {
				if (i * j < maxItem) {
					break;
				}
			}
			partition[i] = j;
			partitionCount += j;
		}

		for (int i = columnPivot; i > 1; i--) {
			int j = partition[columnPivot];
			for (; j < n; j++) {
				if (i * j < maxItem) {
					break;
				}
			}
			partition[i] = j;
			partitionCount += i;
		}

		return partitionCount;
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
