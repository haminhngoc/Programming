import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HarmonyChest2_ForTestOnly {
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
	static Comparator<Item> posComparator = new Comparator<HarmonyChest2_ForTestOnly.Item>() {
		@Override
		public int compare(Item arg0, Item arg1) {
			return Integer.compare(arg0.pos, arg1.pos);
		}
	};
	static Comparator<Item> valueComparator = new Comparator<HarmonyChest2_ForTestOnly.Item>() {
		@Override
		public int compare(Item arg0, Item arg1) {
			return Integer.compare(arg0.a, arg1.a);
		}
	};
	static int[] primes = new int[] { 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
			31, 37, 41, 43, 47, 53, 59 };
	static boolean[][] map = new boolean[61][61];
	static boolean[][] map2 = new boolean[61][61];
	static int[][] map3 = new int[61][61];

	public static void main(String[] args) throws IOException {

		initReader();
		logTime("");
		buildMap();
		logTime("Build Map");

		// printTest(" :\t");
		// for (int i = 0; i < 61; i++) {
		// printTest(i + " ");
		// }
		// printTestLn("");
		// for (int i = 0; i < 61; i++) {
		// printTest(i + ":\t");
		// for (int j = 0; j < 61; j++) {
		// printTest((map[i][j] ? 'T' : 'F') + " ");
		// }
		// printTestLn("");
		// }

		while (true) {
			readInput();

			logTime("Read:");
			solve();
			logTime("Solved:");

			Arrays.sort(a, posComparator);
			for (int i = 0; i < n; i++) {
				System.out.print(a[i].b + " ");
			}

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

		bOptions = new int[n - start][61];
		bCheckedMask = new boolean[n - start][61];
		indexes = new int[n - start];
		for (int i = 0; i < 60; i++) {
			bOptions[0][i] = i + 1;
		}
		Arrays.fill(indexes, 60);
		indexes[0] = -1;

		int[] minB = new int[n - start];
		int minSum = Integer.MAX_VALUE;
		int[] nextOption = getNext();
		int count = 0;
		while (nextOption != null) {

			int sum = 0;
			for (int i = 0; i < nextOption.length; i++) {
				int option = nextOption[i];
				int number = a[start + i].a;
				int min = Math.abs(option - number);
				for (int k = 0; k < 61; k++) {
					if (map3[i][k] != 0) {
						int abs = Math.abs(map3[i][k] - number);
						if (abs < min)
							min = abs;
					} else {
						break;
					}
				}
				sum += min;
			}
			if (sum < minSum) {
				minSum = sum;
				minB = nextOption;
			}

			nextOption = getNext();
			count++;
		}

		for (int i = start; i < n; i++) {
			a[i].b = minB[i - start];
		}

		printTestLn(minSum + " " + count);
	}

	static int[][] bOptions;
	static boolean[][] bCheckedMask;
	static int[] indexes;

	public static int[] getNext() {
		int len = bOptions.length;
		int[] result = new int[len];

		int i = len - 1;
		while (i >= 0) {
			indexes[i]++;
			if (indexes[i] >= 60 || bOptions[i][indexes[i]] == 0) {
				i--;
				continue;
			}

			int current = bOptions[i][indexes[i]];
			if (i < len - 1 && bCheckedMask[i][current]) {
				continue;
			}
			if (i < len - 1) {
				int k = 0;
				int j = indexes[i];
				while (bOptions[i][j] != 0) {
					int next = bOptions[i][j];
					if (!map[current][next]) {
						bOptions[i + 1][k] = next;
						bCheckedMask[i + 1][k] = false;
						k++;
					}
					bCheckedMask[i][j] = map2[current][next];
					j++;
				}
				if (k < 61)
					bOptions[i + 1][k] = 0;
				indexes[i + 1] = -1;
				i++;
				continue;
			}

			if (i == len - 1) {
				for (int j = 0; j < len; j++) {
					result[j] = bOptions[j][indexes[j]];
				}
				break;
			}
		}
		if (i == len - 1) {
			return result;
		}
		return null;
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

		String[] temp = new String[61];
		for (int i = 1; i < primes.length; i++) {
			int p = primes[i];
			for (int j = p; j < 61; j += p) {
				if (temp[j] == null) {
					temp[j] = "" + p;
				} else {
					temp[j] += p;
				}
			}
		}

		for (int i = 0; i < temp.length - 1; i++) {
			for (int j = i + 1; j < temp.length; j++) {
				if (temp[i] != null && temp[j] != null
						&& temp[i].contains(temp[j])) {
					map2[i][j] = true;
					for (int k = 0; k < 61; k++) {
						if (map3[i][k] == 0) {
							map3[i][k] = j;
							break;
						}
					}
				}
			}
		}

		// System.out.println("");
	}

	public static void readInput() throws IOException {
		n = nextInt();
		a = new Item[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Item(nextInt(), i);
		}
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
