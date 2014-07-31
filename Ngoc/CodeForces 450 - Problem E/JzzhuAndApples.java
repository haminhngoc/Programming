import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class JzzhuAndApples {
	static boolean test = false;

	static int n; // 10^6
	// static Apple[] apples;
	static boolean[] isPrimes;
	static boolean[] isPrinteds;

	public static void main(String[] args) throws IOException {
		initReader();
		logTime("");
		while (true) {
			readInput();

			logTime("Read:");
			int result = solve();
			logTime("Solved:");

			if (!test)
				break;
		}

	}

	public static int solve() {
		int count = 0;

		isPrimes = new boolean[n + 1];
		isPrinteds = new boolean[n + 1];
		Arrays.fill(isPrimes, true);
		Arrays.fill(isPrinteds, false);
		int sqrtn = (int) Math.ceil(Math.sqrt(n));
		for (int i = 2; i <= n; i++) {
			if (isPrimes[i] && i <= sqrtn) {
				for (int j = i * i; j <= n; j += i) {
					isPrimes[j] = false;
				}
			}
		}

		StringBuffer result = new StringBuffer();

		List<Integer> list = new ArrayList<Integer>();
		for (int i = n; i >= 2; i--) {
			if (isPrimes[i]) {
				list.clear();
				for (int j = i; j <= n; j += i) {
					if (!isPrinteds[j]) {
						list.add(j);
					}
				}

				int size = list.size();
				if (size > 1) {
					count += size / 2;
					if (size % 2 == 0) {
						for (int k = 0; k < size; k += 2) {
							result.append(list.get(k) + " " + list.get(k + 1)
									+ "\r\n");
							isPrinteds[list.get(k)] = true;
							isPrinteds[list.get(k + 1)] = true;
						}
					} else {
						result.append(list.get(0) + " " + list.get(2) + "\r\n");
						isPrinteds[list.get(0)] = true;
						isPrinteds[list.get(2)] = true;
						for (int k = 3; k < size; k += 2) {
							result.append(list.get(k) + " " + list.get(k + 1)
									+ "\r\n");
							isPrinteds[list.get(k)] = true;
							isPrinteds[list.get(k + 1)] = true;
						}
					}

					//System.out.println("Sum of " + i + " is "+ (size / 2));
				}
			}
		}

		System.out.println(count);
		System.out.println(result);

		return count;
	}

	public static void eratosthenes() {
		// for (int i = 2; i <= n; i++) {
		// if (apples[i].isPrime) {
		// int j = i * i;
		// int count = 1;
		// for (; j <= n; j += i) {
		// apples[j].isPrime = false;
		// }
		// }
		// }
	}

	public static void readInput() throws IOException {
		n = nextInt();
	}

	// static class Apple {
	// public boolean isPrime = true;
	// public boolean printed = false;
	// }

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
