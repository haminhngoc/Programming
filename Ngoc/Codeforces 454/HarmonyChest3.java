import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HarmonyChest3 {
	static boolean test = false;

	static class Item {
		public int a;
		public int pos;
		public int b;

		public Item(int a, int pos) {
			this.a = a;
			this.pos = pos;
		}
	}

	static int n; // 100
	static Item[] a; // 1..30
	static Comparator<Item> posComparator = new Comparator<HarmonyChest3.Item>() {
		@Override
		public int compare(Item arg0, Item arg1) {
			return Integer.compare(arg0.pos, arg1.pos);
		}
	};
	static Comparator<Item> valueComparator = new Comparator<HarmonyChest3.Item>() {
		@Override
		public int compare(Item arg0, Item arg1) {
			return Integer.compare(arg0.a, arg1.a);
		}
	};
	static int[] primes = new int[] { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
			31, 37, 41, 43, 47, 53, 59 };
	static boolean[][] map = new boolean[61][61];

	public static void main(String[] args) throws IOException {

		initReader();
		logTime("");
		buildMap();

		while (true) {
			readInput();

			logTime("Read:");
			solve();
			logTime("Solved:");

			Arrays.sort(a, posComparator);
			StringBuilder sOut = new StringBuilder();
			for (int i = 0; i < n; i++) {
				sOut.append(a[i].b + " ");
			}
			System.out.println(sOut);

			if (!test)
				break;
		}

	}

	public static void solve() {
		Arrays.sort(a, valueComparator);

		int primeLen = primes.length;
		int start = Math.max(n - primeLen + 1, 0);
		for (int i = 0; i < start; i++) {
			a[i].b = 1;
		}

		int len = n - start;
		bOptions = new short[len][39];
		indexes = new short[len];
		result = new int[len];
		short j = 0;
		for (short i = 1; i <= 53; i++) {
			if (i != 52 && i != 51 && i != 50 && i != 48 && i != 46 && i != 45
					&& i != 44 && i != 42 && i != 40 && i != 39 && i != 38
					&& i != 35 && i != 36 && i != 34 && i != 33) {
				bOptions[0][j++] = i;
			}
		}
		Arrays.fill(indexes, (short) 60);
		indexes[0] = -1;

		int[] minB = null;
		int minSum = Integer.MAX_VALUE;
		while (getNext()) {
			int sum = 0;
			for (int i = 0; i < len; i++) {
				sum += Math.abs(result[i] - a[start + i].a);
			}
			if (sum < minSum) {
				minSum = sum;
				minB = result;
				result = new int[len];
			}
		}

		for (int i = start; i < n; i++) {
			a[i].b = minB[i - start];
		}
	}

	static short[][] bOptions;
	static short[] indexes;
	static int[] result;

	public static boolean getNext() {
		int len = bOptions.length;

		int i = len - 1;
		while (i >= 0) {
			indexes[i]++;
			if (indexes[i] >= 39 || bOptions[i][indexes[i]] == 0) {
				i--;
				continue;
			}

			if (i < len - 1) {
				int current = bOptions[i][indexes[i]];
				int k = 0;
				int j = indexes[i];
				while (bOptions[i][j] != 0) {
					if (!map[current][bOptions[i][j]]) {
						bOptions[i + 1][k] = bOptions[i][j];
						k++;
					}
					j++;
				}
				if (k < 61)
					bOptions[i + 1][k] = 0;
				indexes[i + 1] = -1;
				i++;
				continue;
			}

			else {
				for (int j = 0; j < len; j++) {
					result[j] = bOptions[j][indexes[j]];
				}
				return true;
			}
		}
		return false;
	}

	public static void buildMap() {
		for (int i = 1; i < primes.length; i++) {
			int p = primes[i];
			int r, c;
			for (r = p; r <= 60; r += p) {
				for (c = p; c <= 60; c += p) {
					map[r][c] = true;
				}
			}
		}
	}

	public static void readInput() throws IOException {
		n = nextInt();
		a = new Item[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Item(nextInt(), i);
		}
	}

	/*
	 * Exclusives 2 4 8 16 32 | 3 9 27 | 4 8 16 36 | 5 25 | 6 8 9 12 16 18 24 27
	 * 32 | 8 16 32 | 9 27 | 10 16 20 32 | 12 16 18 24 27 32 | 14 16 28 32 | 16
	 * 32 | 18 24 27 32 | 20 32 | 22 32 | 24 27 32 | 26 32 | 28 32 | 30 32 |
	 */

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
