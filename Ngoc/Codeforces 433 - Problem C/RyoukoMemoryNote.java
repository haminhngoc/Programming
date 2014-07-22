import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class RyoukoMemoryNote {
	static boolean test = false;

	static int n; // 10^5
	static int m; // 10^5
	static int[] a;

	public static void main(String[] args) throws IOException {
		initReader();
		logTime("");
		while (true) {
			readInput();

			logTime("Read:");
			long result = solve();
			logTime("Solved:");

			System.out.println(result);

			if (!test)
				break;
		}

	}

	public static long solve() {
		long result = 0;

		int[] in = new int[n];
		int[] out = new int[n];
		List<PointInfor> list = new ArrayList<PointInfor>();
		for (int i = 0; i < m; i++) {
			if (i < m - 1 && a[i] != a[i + 1]) {
				list.add(new PointInfor(a[i], a[i + 1]));
			}
			if (i > 0 && a[i - 1] != a[i]) {
				list.add(new PointInfor(a[i], a[i - 1]));
			}
			if (i < m - 1) {
				if (a[i] < a[i + 1]) {
					in[a[i] - 1]++;
					out[a[i + 1] - 1]++;
				} else {
					in[a[i] - 1]--;
					out[a[i + 1] - 1]--;
				}
				result += Math.abs(a[i] - a[i + 1]);
			}
		}

		int maxSegment = 0;
		int segment = 0;
		for (int i = 0; i < n; i++) {
			segment += in[i];
			segment -= out[i];
			if (in[i] == 0 && out[i] == 0 && segment > maxSegment) {
				maxSegment = segment;
			}
		}

		printTestLn(result, maxSegment);

		Comparator<PointInfor> comparator = new Comparator<PointInfor>() {
			public int compare(PointInfor arg0, PointInfor arg1) {
				if (arg0.X > arg1.X)
					return 1;
				else if (arg0.X < arg1.X)
					return -1;
				else
					return Integer.compare(arg0.Connect, arg1.Connect);
			}
		};

		list.sort(comparator);
		printTestLn(list.toArray());

		long maxChange = 0;
		int size = list.size();
		int firstIndex = 0;
		PointInfor first = size > 0 ? list.get(firstIndex) : null;
		for (int i = 0; i < size; i++) {
			PointInfor point = null;
			if (i < size - 1) {
				point = list.get(i + 1);
			}
			if (point == null || point.X != first.X) {
				int j = (i + firstIndex) / 2;
				int xj = list.get(j).Connect;

				long localChange = 0;
				for (int l = firstIndex; l <= i; l++) {
					PointInfor lInfor = list.get(l);
					localChange += (Math.abs(lInfor.X - lInfor.Connect) - Math
							.abs(lInfor.Connect - xj));
				}
				maxChange = Math.max(localChange, maxChange);
				printTestLn(first, firstIndex, i, j, localChange, list.get(j));
				firstIndex = i + 1;
				first = point;
			}
		}

		result -= Math.max(maxChange, maxSegment);

		return result;
	}

	public static void readInput() throws IOException {
		n = nextInt();
		m = nextInt();
		a = readArray(m);
	}

	/*****************************************************************
	 ******************** BASIC READER *******************************
	 *****************************************************************/

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

	/*****************************************************************
	 ******************** TIME UTILITIES *******************************
	 *****************************************************************/

	static long startTime = 0;
	static long preLogTime = 0;

	static void logTime(String lable) {
		if (!test)
			return;
		long current = System.currentTimeMillis();
		if (startTime != 0) {
			println(lable, " - From start:", (current - startTime),
					"- From previous:", (current - preLogTime));
		} else {
			startTime = current;
		}
		preLogTime = current;
	}

	/*****************************************************************
	 ******************** READ UTILITIES *******************************
	 *****************************************************************/

	public static int[] readArray(int n) throws IOException {
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = nextInt();
		}
		return result;
	}

	public static long[] readArrayLong(int n) throws IOException {
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

	/*****************************************************************
	 ******************** PRINT UTILITIES *******************************
	 *****************************************************************/

	public static void printTest(Object... obj) {
		if (!test)
			return;
		System.out.print(join(obj, " "));
	}

	public static void printTestLn(Object... obj) {
		if (!test)
			return;
		System.out.println(join(obj, " "));
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

	/*****************************************************************
	 *************** ARRAY AND STRING UTILITIES **********************
	 *****************************************************************/

	public static int[] initArray(int value, int length) {
		int[] result = new int[length];
		Arrays.fill(result, value);
		return result;
	}

	public static long[] initArray(long value, int length) {
		long[] result = new long[length];
		Arrays.fill(result, value);
		return result;
	}

	public static String initString(char c, int length) {
		char[] chars = new char[length];
		Arrays.fill(chars, c);
		return new String(chars);
	}
}

class PointInfor {
	int X;
	int Connect;

	public PointInfor(int x, int connect) {
		X = x;
		Connect = connect;
	}

	public String toString() {
		return "(" + X + "," + Connect + ")";
	}
}
