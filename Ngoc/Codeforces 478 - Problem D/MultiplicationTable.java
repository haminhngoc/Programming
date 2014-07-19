import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MultiplicationTable {
	static int n; // 500K
	static int m; // 500K
	static int k; // n * m

	static int lowCount;
	static int[] lowPartition;

	static int upCount;
	static int[] upPartition;

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
		if (m < n) {
			int temp = m;
			m = n;
			n = temp;
		}
		int ksmallest = m * n - k + 1;
		lowPartition = new int[m + 1];
		lowCount = 0;

		upPartition = new int[m + 1];
		for (int i = 0; i < m; i++) {
			upPartition[i] = n + 1;
		}
		upPartition[m] = n;
		upCount = m * n;

		int[] partition = new int[m + 1];

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
				if (ksmallest <= partitionCount) {
					upPartition = partition;
					upCount = partitionCount;
				} else {
					lowPartition = partition;
					lowCount = partitionCount;
				}
			} else {
				List<Integer> inPartition = new ArrayList<Integer>();
				for (int i = 1; i <= m; i++) {
					if (upPartition[i] >= 1 && upPartition[i] <= n
							&& upPartition[i] > lowPartition[i]) {
						inPartition.add(upPartition[i] * i);
					}
				}
				inPartition.sort(comparator());
				return inPartition.get(ksmallest - lowCount);
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

	public static Comparator<Integer> comparator() {
		return new Comparator<Integer>() {
			public int compare(Integer arg0, Integer arg1) {
				return Integer.compare(arg0, arg1);
			}
		};
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
	
	
	public static int[] readLine(int n) throws IOException {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = nextInt();
		}
		return result;
	}

	public static long[] readLineLong(int n) throws IOException {
		long[] result = new long[n];
		for (int i = 0; i < n; i++) {
			result[i] = nextLong();
		}
		return result;
	}

	public static int[][] readMatrix(int row, int column) throws IOException {
		int[][] result = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				result[i][j] = nextInt();
			}
		}
		return result;
	}

	public static long[][] readMatrixLong(int row, int column)
			throws IOException {
		long[][] result = new long[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				result[i][j] = nextLong();
			}
		}
		return result;
	}

	public static void print(Object... obj) {
		System.out.print(join(obj, " "));
	}

	public static void println(Object... obj) {
		System.out.println(join(obj, " "));
	}

	public static String join(Object[] objs) {
		return join(objs, " ");
	}

	public static String join(int[] objs) {
		return join(objs, " ");
	}

	public static String join(long[] objs) {
		return join(objs, " ");
	}

	public static String join(Object[] objs, String glue) {
		if (objs.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < objs.length - 1; i++) {
			sb.append(objs[i] + glue);
		}
		return sb.toString() + objs[i];
	}

	public static String join(int[] objs, String glue) {
		if (objs.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < objs.length - 1; i++) {
			sb.append(objs[i] + glue);
		}
		return sb.toString() + objs[i];
	}

	public static String join(long[] objs, String glue) {
		if (objs.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < objs.length - 1; i++) {
			sb.append(objs[i] + glue);
		}
		return sb.toString() + objs[i];
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			println(join(matrix[i]));
		}
	}

	public static void printMatrix(long[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			println(join(matrix[i]));
		}
	}
}
