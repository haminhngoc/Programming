import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SpecialGrid3 {

	static int n; // 400
	static int m; // 400
	static short[][][] a;
	static int[][] vectors = new int[][] { { 0, 1 }, { 1, 1 }, { 1, 0 },
			{ 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };
	// Level1_Start, Level1_Step, Level1_Step
	static int[][] traverseVectors = new int[][] {
			{ 0, 0, 1, 0, 0, 1 /* Rows */}, { 0, 0, 0, 1, 1, 0 /* Column */},
			{ 0, 0, 1, 0, 1, 1 /*
								 * Left to BottomRight
								 */},
			{ 0, 1, 0, 1, 1, 1 /* Top to BottomRight */},
			{ -1, 0, -1, 0, -1, 1 /* Left to TopRight */},
			{ -1, 1, 0, 1, -1, 1 /* Bottom to TopRight */} };
	static int[][] map = new int[][] { { 0, 4 }, { 2, 6 }, { 1, 5 }, { 1, 5 },
			{ 7, 3 }, { 7, 3 } };

	public static void main(String[] args) throws IOException {
		initReader();
		readInput();
		long result = solve();

		System.out.println(result);
	}

	public static long solve() {
		traverseVectors[4][0] = n - 1;
		traverseVectors[5][0] = n - 1;
		for (int k = 0; k < 6; k++) {
			int[] vector = traverseVectors[k];
			int x = vector[0], y = vector[1];
			int incx = vector[2], incy = vector[3];
			int inci = vector[4], incj = vector[5];
			int root0 = map[k][0], root1 = map[k][1];

			for (; 0 <= x && x < n && 0 <= y && y < m; x += incx, y += incy) {
				int i = x, j = y;
				int prei = -1, prej = -1;
				for (; -1 <= i && i <= n && -1 <= j && j <= m; i += inci, j += incj) {
					boolean aij = (0 <= i && i < n && 0 <= j && j < m) ? (a[i][j] != null)
							: false;
					if (prei < 0 && aij) {
						prei = i;
						prej = j;
					} else if (prei >= 0 && !aij) {
						int di = prei, dj = prej;
						int len = Math.max(Math.abs(prei - i),
								Math.abs(prej - j)) - 1;
						int sublen = 0;
						while (di != i || dj != j) {
							a[di][dj][root0] = (short) Math.max(
									a[di][dj][root0], len);
							a[di][dj][root1] = (short) Math.max(
									a[di][dj][root1], sublen);
							di += inci;
							dj += incj;
							len--;
							sublen++;
						}
						prei = -1;
						prej = -1;
					}
				}
			}
		}

		return countTriangle2();
	}

	public static long countTriangle2() {
		long count = 0;
		for (int k = 0, nextk = 2; k < 8; k++, nextk = ((nextk + 1) & 0x00000007)) {
			int nextK = ((k + 3) & 0x00000007);
			int vx = vectors[k][0], vy = vectors[k][1];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					short[] point = a[i][j];
					if (point != null) {
						int edge = Math.min(point[k], point[nextk]);
						for (int u = 1, nextX = i + vx, nextY = j + vy; u <= edge; u++, nextX += vx, nextY += vy) {
							int needLen = ((k & 0x00000001) == 0 ? u : 2 * u);
							/*
							 * This line below take 400+ms. Just to read 1.3M
							 * times from memory
							 */
							if (a[nextX][nextY][nextK] >= needLen) {
								count++;
							}
						}

					}
				}
			}
		}
		return count;
	}

	public static void readInput() throws IOException {
		n = nextInt();
		m = nextInt();
		a = new short[n][m][];

		for (int i = 0; i < n; i++) {
			String line = nextLine();
			for (int j = 0; j < m; j++) {
				if (line.charAt(j) == '0') {
					a[i][j] = new short[8];
				} else {
					a[i][j] = null;
				}
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
	

	public static long countTriangle() {
		long count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				short[] point = a[i][j];
				if (point != null) {
					for (int k = 0, nextk = 2; k < 8; k++, nextk = ((nextk + 1) & 0x00000007)) {
						int edge = Math.min(point[k], point[nextk]);
						int vx = vectors[k][0], vy = vectors[k][1];
						int nextK = ((k + 3) & 0x00000007);
						for (int u = 1, nextX = i + vx, nextY = j + vy; u <= edge; u++, nextX += vx, nextY += vy) {
							int needLen = ((k & 0x00000001) == 0 ? u : 2 * u);
							/*
							 * This line below take 800+ms. Just to read 1.3M
							 * times from memory
							 */
							if (a[nextX][nextY][nextK] >= needLen) {
								count++;
							}
						}
					}

				}
			}
		}
		return count;
	}
	
	public static void printMatrix() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// if (point != null) {
				// for (int k = 0; k < 8; k++) {
				// System.out.print(point.rootEdges[k]);
				// }
				// } else {
				// System.out.print(" ");
				// }
				// System.out.print("\t|");
			}
			System.out.println("");
		}
	}

}
