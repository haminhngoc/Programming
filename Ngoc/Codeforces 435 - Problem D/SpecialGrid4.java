import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SpecialGrid4 {

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
		return countTriangle4();
	}

	public static long countTriangle4() {
		long count = 0;
		short[] point, nextPoint;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				point = a[i][j];
				if (point != null) {
					for (int u = j + 1; u < m; u++) {
						int len = u - j;
						if (point[0] >= len) {
							nextPoint = a[i][u];
							if (point[2] >= len && nextPoint[3] >= len)
								count++;
							if (point[6] >= len && nextPoint[5] >= len)
								count++;
							if (point[1] >= len && nextPoint[2] >= len)
								count++;
							if (point[7] >= len && nextPoint[6] >= len)
								count++;
							if ((len & 0x00000001) == 0) {
								int halfLen = len >> 1;
								if (point[1] >= halfLen
										&& nextPoint[3] >= halfLen)
									count++;
								if (point[7] >= halfLen
										&& nextPoint[5] >= halfLen)
									count++;
							}
							// System.out.println(count + ": " + i + "," + j
							// + " - " + i + "," + u);
						}
					}
					for (int u = i + 2; u < n; u += 2) {
						int len = u - i;
						if (point[2] >= len) {
							int haftLen = len >> 1;
							nextPoint = a[u][j];
							if (point[1] >= haftLen && nextPoint[7] >= haftLen)
								count++;
							if (point[3] >= haftLen && nextPoint[5] >= haftLen)
								count++;
						}
						// System.out.println(count + ": " + i + "," + j + " - "
						// + u + "," + j);
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
}
