import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SpecialGrid {

	static int n; // 400
	static int m; // 400
	static boolean[][] a;
	static GridPoint[][] points;
	static int[][] vectors = new int[][] { { 0, 1 }, { 1, 1 }, { 1, 0 },
			{ 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
	static int[] map8 = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 0, 1, 2, 3, 4, 5,
			6, 7 };

	public static void main(String[] args) throws IOException {
		initReader();
		readInput();
		long result = solve();
		System.out.println(result);
	}

	public static int solve() {
		int result = 0;

		initPoints();

		int loop = Math.max(n, m);

		for (int level = 1; level < loop; level++) {
			for (int i = 0; i < n; i++) {
				int limitm = i < n - level ? m : m - level;
				for (int j = 0; j < limitm; j++) {
					GridPoint point = points[i][j];
					if (point != null) {
						// processPoint(point, i, j, level);
						// for (int k = 0; k < 8; k++) {
						for (int k = 0; k < 4; k++) {
							int dx = vectors[k][0] * level;
							int dy = vectors[k][1] * level;
							int x = i + dx;
							int y = j + dy;

							if (point.rootEdges[k] == level - 1 && x >= 0
									&& x < n && y >= 0 && y < m && a[x][y]) {
								point.rootEdges[k]++;
								points[x][y].rootEdges[map8[k + 4]]++;

								if (((dx + dy) & 0x00000001) == 0) {
									int x1 = i + (dx - dy) / 2;
									int y1 = j + (dx + dy) / 2;
									if (0 <= x1 && x1 < n && 0 <= y1 && y1 < m
											&& points[x1][y1] != null) {
										points[x1][y1].frontEdges[map8[k + 1]] = ((k & 0x00000001) == 0 ? level >> 1
												: level);
									}
									x1 = i + (dx + dy) / 2;
									y1 = j + (dy - dx) / 2;
									if (0 <= x1 && x1 < n && 0 <= y1 && y1 < m
											&& points[x1][y1] != null) {
										points[x1][y1].frontEdges[map8[k + 5]] = ((k & 0x00000001) == 0 ? level >> 1
												: level);
									}
								}

							}
						}
					}
				}
			}
			// result += checkAndClearTriangle();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					GridPoint point = points[i][j];
					if (point != null) {
						for (int k = 0; k < 8; k++) {
							int nextk = map8[k + 2];
							if (point.rootEdges[k] >= point.frontEdges[k]
									&& point.rootEdges[nextk] >= point.frontEdges[k]) {
								result++;
							}
							point.frontEdges[k] = 10000;
						}
					}
				}
			}

		}

		return result;
	}

	public static void processPoint(GridPoint point, int i, int j, int level) {
		for (int k = 0; k < 8; k++) {
			int dx = vectors[k][0] * level;
			int dy = vectors[k][1] * level;
			int x = i + dx;
			int y = j + dy;

			if (point.rootEdges[k] == level - 1 && x >= 0 && x < n && y >= 0
					&& y < m && a[x][y]) {
				point.rootEdges[k]++;
				if ((dx + dy) % 2 == 0) {
					int x1 = i + (dx - dy) / 2;
					int y1 = j + (dx + dy) / 2;
					if (0 <= x1 && x1 < n && 0 <= y1 && y1 < m
							&& points[x1][y1] != null) {
						points[x1][y1].frontEdges[map8[k + 1]] = (k % 2 == 0 ? level >> 1
								: level);
					}
					x1 = i + (dx + dy) / 2;
					y1 = j + (dy - dx) / 2;
					if (0 <= x1 && x1 < n && 0 <= y1 && y1 < m
							&& points[x1][y1] != null) {
						points[x1][y1].frontEdges[map8[k + 5]] = (k % 2 == 0 ? level >> 1
								: level);
					}
				}
			}
		}
	}

	public static long checkAndClearTriangle() {
		long count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				GridPoint point = points[i][j];
				if (point != null) {
					for (int k = 0; k < 8; k++) {
						int nextk = map8[k + 2];
						if (point.rootEdges[k] >= point.frontEdges[k]
								&& point.rootEdges[nextk] >= point.frontEdges[k]) {
							count++;
						}
						point.frontEdges[k] = 10000;
					}
				}
			}
		}
		return count;
	}

	public static void initPoints() {
		points = new GridPoint[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j]) {
					points[i][j] = new GridPoint();
				}
			}
		}
	}

	public static void readInput() throws IOException {
		n = nextInt();
		m = nextInt();
		a = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String line = nextLine();
			for (int j = 0; j < m; j++) {
				char c = line.charAt(j);
				a[i][j] = (c == '0');
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
}

class GridPoint {
	public int[] rootEdges;
	public int[] frontEdges;

	public GridPoint() {
		this.rootEdges = new int[8];
		Arrays.fill(rootEdges, 0);
		this.frontEdges = new int[8];
		Arrays.fill(frontEdges, 10000);
	}
}

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < m; j++) {
// GridPoint point = points[i][j];
// if (point != null) {
// printTest(join(point.frontEdges, ""));
// }
// printTest("\t|");
// }
// printTestLn("");
// }

/*
 * 
 * public static long solve_wrong2_has_some_good_ideas() { int result = 0;
 * 
 * boolean[][][] preLevel = new boolean[n][m][4]; boolean[][][] level = new
 * boolean[n][m][4];
 * 
 * int[][] oldIndexes = new int[][] { { 0, 1, 1 }, { 1, 0, 2 }, { 0, -1, 3 }, {
 * -1, 0, 0 } }; int[][] evenIndexes = new int[][] { { 1, 1, 2 }, { 1, -1, 3 },
 * { -1, -1, 0 }, { -1, 1, 1 } };
 * 
 * int countLevel = 0; int[][] indexes = oldIndexes; for (int i = 0; i < n; i++)
 * { for (int j = 0; j < m; j++) { if (!a[i][j]) { printTest("|\t"); continue; }
 * int x = i + indexes[3][0]; int y = j + indexes[3][1]; int pre = (0 <= x && x
 * < n && 0 <= y && y < m && a[x][y]) ? 3 : -1; for (int k = 0; k < 4; k++) { x
 * = i + indexes[k][0]; y = j + indexes[k][1]; if (0 <= x && x < n && 0 <= y &&
 * y < m && a[x][y] && pre >= 0) { level[i][j][pre] = true; countLevel++;
 * printTest(pre); } pre = (0 <= x && x < n && 0 <= y && y < m && a[x][y]) ? k :
 * -1; } printTest("|\t"); } printTestLn(""); }
 * 
 * printTestLn(countLevel); result += countLevel;
 * 
 * int currentLevel = 1; indexes = oldIndexes; while (countLevel > 0) {
 * boolean[][][] temp = preLevel; preLevel = level; level = temp; for (int i =
 * 0; i < n; i++) { for (int j = 0; j < m; j++) { Arrays.fill(level[i][j],
 * false); } } countLevel = 0; for (int i = 0; i < n; i++) { for (int j = 0; j <
 * m; j++) { boolean[] cell = preLevel[i][j]; boolean preValue = cell[3]; for
 * (int k = 0; k < 4; k++) { if (preValue && cell[k]) { // if (indexes ==
 * oldIndexes) { int x = i + indexes[k][0] * currentLevel; int y = j +
 * indexes[k][1] * currentLevel; if (0 <= x && x < n && 0 <= y && y < m) {
 * level[x][y][indexes[k][2]] = true; countLevel++; // printTest(indexes[k][2]);
 * } // } else { // } } preValue = cell[k]; } } }
 * 
 * for (int i = 0; i < n; i++) { for (int j = 0; j < m; j++) { for (int k = 0; k
 * < 4; k++) if (level[i][j][k]) printTest(k); printTest("|\t"); }
 * printTestLn(""); }
 * 
 * if (indexes == oldIndexes) { indexes = evenIndexes; } else { indexes =
 * oldIndexes; currentLevel++; }
 * 
 * printTestLn(countLevel); result += countLevel; }
 * 
 * return result; }
 * 
 * public static long solve_wrong_has_some_good_ideas() {
 * 
 * int x = 1; int y = 0; int result = 0; while (y < m) { int i = x; int j = y;
 * int prej = a[i][j] ? j : -1; while (i >= 0 && j < m) { i--; j++; if (i == -1
 * || j == m || !a[i][j]) { if (prej >= 0 && prej < j) { result += (j - prej) *
 * (j - prej - 1) / 2; } prej = -1; } else if (prej == -1) { prej = j; } } if (x
 * < n - 1) x++; else y++; System.out.println(result); }
 * 
 * x = 1; y = m - 1; while (y >= 0) { int i = x; int j = y; int prej = a[i][j] ?
 * j : -1; while (i >= 0 && j >= 0) { i--; j--; if (i == -1 || j == -1 ||
 * a[i][j]) { if (prej >= 0 && prej < j) { result += (prej - j) * (prej - j - 1)
 * / 2; } prej = -1; } else if (prej == -1) { prej = j; } } if (x < n - 1) x++;
 * else y--; System.out.println(result); }
 * 
 * return result; }
 */