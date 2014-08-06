import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CountGoodSubstrings {
	static boolean test = false;

	static char[] chars;

	public static void main(String[] args) throws IOException {

		initReader();
		logTime("");
		while (true) {
			readInput();

			logTime("Read:");
			solve();
			logTime("Solved:");

			if (!test)
				break;
		}

	}

	static class Infor {
		long sum = 0;
		long sum2 = 0;
		long oddCount = 0;
		long eventCount = 0;
		long diffOdd = 0;
		long diffEvent = 0;
		long selfOdd = 0;
		long selfEvent = 0;

		public void add(int from, int to) {
			int len = to - from + 1;
			sum += len;
			sum2 += (len * len);
			if ((len & 0x00000001) != 0) {
				if ((to & 0x00000001) != 0) {
					diffOdd += oddCount;
					diffEvent += eventCount;
					oddCount++;
				} else {
					diffOdd += eventCount;
					diffEvent += oddCount;
					eventCount++;
				}
			}

			long countSelf = (len * (len + 1)) >> 1;
			long diffSelf = (len + 1) / 2;
			selfOdd += (countSelf + diffSelf) / 2;
			selfEvent += (countSelf - diffSelf) / 2;
		}

		public long getOdd() {
			long total = (sum * sum - sum2) / 2; // Odd + Event
			long diff = diffOdd - diffEvent; // Odd - Event
			return (total + diff) / 2 + selfOdd;
		}

		public long getEvent() {
			long total = (sum * sum - sum2) / 2; // Odd + Event
			long diff = diffOdd - diffEvent; // Odd - Event
			return (total - diff) / 2 + selfEvent;
		}
	}

	public static void solve() {
		long count = 0;

		Infor inforA = new Infor();
		Infor inforB = new Infor();

		int n = chars.length;
		int pre = 0;
		char preChar = chars[pre];
		for (int i = 1; i <= n; i++) {
			if (i == n || chars[i] != preChar) {

				if (preChar == 'a')
					inforA.add(pre, i - 1);
				else
					inforB.add(pre, i - 1);

				pre = i;
				preChar = pre < n ? chars[pre] : '\0';
			}
		}

		long event = inforA.getEvent() + inforB.getEvent();
		long odd = inforA.getOdd() + inforB.getOdd();
		System.out.println(event + " " + odd);
	}

	public static void readInput() throws IOException {
		String text = nextLine();
		chars = text.toCharArray();
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
