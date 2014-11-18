import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

class FLOYD {
	public static void main(String[] args) {
		solve();
	}

	static int[][] a;
	static int n;
	static int m;

	static void solve() {
		n = nextInt();
		m = nextInt();
		int k = nextInt();
		a = new int[n][n];
		for (int i = 0; i < m; i++) {
			int x = nextInt();
			int y = nextInt();
			int dis = nextInt();
			a[x - 1][y - 1] = dis;
			a[y - 1][x - 1] = dis;
		}

		int[][] q = new int[k][3];
		getMinDis();
		for (int i = 0; i < k; i++) {
			int type = nextInt();
			int u = nextInt();
			int v = nextInt();
			if (type == 0) {
				System.out.println(minDis[u - 1][v - 1]);
			} else {
				getMinRoad(u - 1, v - 1);
			}
		}

	}

	private static void getMinRoad(int u, int v) {// Dijkstra
		int[] dist = new int[n];
		int[] prev = new int[n];
		boolean[] visited = new boolean[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(prev, -1);
		dist[u] = 0;
		for (int i = 0; i < n; i++) {
			int cur = 0;
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					cur = j;
				}
			}

			visited[cur] = true;

			for (int j = 0; j < n; j++) {
				if (!visited[j] && a[cur][j] != 0) {
					int lenghtToNeighbour = dist[cur] + a[cur][j];
					if (lenghtToNeighbour < dist[j]) {
						dist[j] = lenghtToNeighbour;
						prev[j] = cur;
					}
				}
			}
		}
		StringBuilder res = new StringBuilder();
		int[] road = new int[n];
		int length = 0;
		while (v >= 0 && v != u) {
			road[length++] = v + 1;
			v = prev[v];
		}
		road[length++] = u + 1;
		for (int i = length - 1; i > 0; --i) {
			res.append(road[i] + " ");
		}
		res.append(road[0]);
		System.out.println(length + " " + res);
	}

	static int[][] minDis;

	private static void getMinDis() {// ployd-warshall
		minDis = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(minDis[i], Integer.MAX_VALUE);
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					minDis[i][j] = 0;
				}
				if (a[i][j] != 0) {
					minDis[i][j] = a[i][j];
				}
			}
		}
		for (int k = 0; k < n; ++k) {
			for (int i = 0; i < n; ++i) {
				if (minDis[i][k] == Integer.MAX_VALUE) {
					continue;
				}
				for (int j = 0; j < n; ++j) {
					if (minDis[k][j] == Integer.MAX_VALUE) {
						continue;
					}
					if (minDis[i][j] > minDis[i][k] + minDis[k][j]) {
						minDis[i][j] = minDis[i][k] + minDis[k][j];
					}
				}
			}
		}

	}

	/*****************************************************************
	 ******************** BASIC READER *******************************
	 *****************************************************************/

	static InputStream is = System.in;
	static private byte[] inbuf = new byte[1024];
	static private int lenbuf = 0, ptrbuf = 0;

	static private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static private boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static private int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static private double nextDouble() {
		return Double.parseDouble(nextString());
	}

	static private char nextChar() {
		return (char) skip();
	}

	static private String nextString() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static private char[] nextString(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static private int[][] nextMatrix(int n, int m) {
		int[][] map = new int[n][];
		for (int i = 0; i < n; i++)
			map[i] = nextAi(n);
		return map;
	}

	static private int[] nextAi(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	static private Integer[] nextAI(int n) {
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	static private int nextInt() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static private long nextLong() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}
}

