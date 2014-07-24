import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SpecialGrid {
	static boolean test = true;

	static int n; // 400
	static int m; // 400
	static char[][] a;

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
		int result = 0;
		
		return result;
	}

	public static long solve_wrong2() {
		int result = 0;

		boolean[][][] preLevel = new boolean[n][m][4];
		boolean[][][] level = new boolean[n][m][4];

		int[][] oldIndexes = new int[][] { { 0, 1, 1 }, { 1, 0, 2 },
				{ 0, -1, 3 }, { -1, 0, 0 } };
		int[][] evenIndexes = new int[][] { { 1, 1, 2 }, { 1, -1, 3 },
				{ -1, -1, 0 }, { -1, 1, 1 } };

		int countLevel = 0;
		int[][] indexes = oldIndexes;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] != '0') {
					printTest("|\t");
					continue;
				}
				int x = i + indexes[3][0];
				int y = j + indexes[3][1];
				int pre = (0 <= x && x < n && 0 <= y && y < m && a[x][y] == '0') ? 3
						: -1;
				for (int k = 0; k < 4; k++) {
					x = i + indexes[k][0];
					y = j + indexes[k][1];
					if (0 <= x && x < n && 0 <= y && y < m && a[x][y] == '0'
							&& pre >= 0) {
						level[i][j][pre] = true;
						countLevel++;
						printTest(pre);
					}
					pre = (0 <= x && x < n && 0 <= y && y < m && a[x][y] == '0') ? k
							: -1;
				}
				printTest("|\t");
			}
			printTestLn("");
		}

		printTestLn(countLevel);
		result += countLevel;

		int currentLevel = 1;
		indexes = oldIndexes;
		while (countLevel > 0) {
			boolean[][][] temp = preLevel;
			preLevel = level;
			level = temp;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					Arrays.fill(level[i][j], false);
				}
			}
			countLevel = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					boolean[] cell = preLevel[i][j];
					boolean preValue = cell[3];
					for (int k = 0; k < 4; k++) {
						if (preValue && cell[k]) {
							// if (indexes == oldIndexes) {
							int x = i + indexes[k][0] * currentLevel;
							int y = j + indexes[k][1] * currentLevel;
							if (0 <= x && x < n && 0 <= y && y < m) {
								level[x][y][indexes[k][2]] = true;
								countLevel++;
								// printTest(indexes[k][2]);
							}
							// } else {
							// }
						}
						preValue = cell[k];
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					for (int k = 0; k < 4; k++)
						if (level[i][j][k])
							printTest(k);
					printTest("|\t");
				}
				printTestLn("");
			}

			if (indexes == oldIndexes) {
				indexes = evenIndexes;
			} else {
				indexes = oldIndexes;
				currentLevel++;
			}

			printTestLn(countLevel);
			result += countLevel;
		}

		return result;
	}

	public static long solve_wrong() {

		int x = 1;
		int y = 0;
		int result = 0;
		while (y < m) {
			int i = x;
			int j = y;
			int prej = a[i][j] == '0' ? j : -1;
			while (i >= 0 && j < m) {
				i--;
				j++;
				if (i == -1 || j == m || a[i][j] == '1') {
					if (prej >= 0 && prej < j) {
						result += (j - prej) * (j - prej - 1) / 2;
					}
					prej = -1;
				} else if (prej == -1) {
					prej = j;
				}
			}
			if (x < n - 1)
				x++;
			else
				y++;
			System.out.println(result);
		}

		x = 1;
		y = m - 1;
		while (y >= 0) {
			int i = x;
			int j = y;
			int prej = a[i][j] == '0' ? j : -1;
			while (i >= 0 && j >= 0) {
				i--;
				j--;
				if (i == -1 || j == -1 || a[i][j] == '1') {
					if (prej >= 0 && prej < j) {
						result += (prej - j) * (prej - j - 1) / 2;
					}
					prej = -1;
				} else if (prej == -1) {
					prej = j;
				}
			}
			if (x < n - 1)
				x++;
			else
				y--;
			System.out.println(result);
		}

		return result;
	}

	public static void readInput() throws IOException {
		n = nextInt();
		m = nextInt();
		a = new char[n][m];
		for (int i = 0; i < n; i++) {
			String line = nextLine();
			for (int j = 0; j < m; j++) {
				char c = line.charAt(j);
				a[i][j] = c;
			}
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
