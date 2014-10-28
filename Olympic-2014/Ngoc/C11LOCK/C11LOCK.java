import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

class C11LOCK {
	static InputStream is;
	static PrintWriter out;
	static String INPUT = "";

	public static void main(String[] args) throws Exception {
		oj = true;
		is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		out = new PrintWriter(System.out);

		long s = System.currentTimeMillis();
		solve();
		out.flush();
		tr(System.currentTimeMillis() - s + "ms");
	}

	static void solve2() {
		int n = ni();
		int k = ni();

		int groupSize = n * n;
		int result = 0;

		for (int i = 0; i < n; i++) {
			int x = 0, y = 0;
			while (x < groupSize && y < groupSize) {
				if (x < y)
					x++;
				else
					y++;
				result++;
			}
		}

		System.out.println(result);
	}

	static void solve() {
		int n = ni();
		int k = ni();
		int[] a1 = na(n);
		int[] a2 = na(n);
		int[] a3 = na(n);
		int[] a4 = na(n);
		int[] a5 = na(n);

		int groupSize = n * n;
		Integer[] g12 = new Integer[groupSize];
		Integer[] g45 = new Integer[groupSize];

		int g = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g12[g] = a1[i] + a2[j];
				g++;
			}
		}

		g = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				g45[g] = k - a4[i] - a5[j];
				g++;
			}
		}

		Arrays.sort(g12);
		Arrays.sort(a3);
		Arrays.sort(g45);

		int result = 0;

		// Problem: Access Memory too many times: 250M
		for (int i = 0; i < n; i++) {
			int a3i = a3[i];

			int x = 0, y = 0;
			while (x < groupSize && y < groupSize) {
				int v123 = g12[x] + a3i;
				int v45 = g45[y];
				if (v123 == v45) {
					int curX = x;
					x++;
					while (x < groupSize && g12[x - 1] == g12[x]) {
						x++;
					}

					int curY = y;
					y++;
					while (y < groupSize && g45[y - 1] == g45[y]) {
						y++;
					}

					result += (x - curX) * (y - curY);
				}
				else if (v123 < v45) {
					x++;
				}
				else /* v123 > v45 */{
					y++;
				}
			}
		}

		System.out.println(result);
	}

	/*
	 * *****************************************************************
	 * ******************* BASIC READER ******************************* ***************************************************************
	 */

	static byte[] inbuf = new byte[16384];
	static int lenbuf = 0, ptrbuf = 0;

	static int readByte() {
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

	static boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static double nd() {
		return Double.parseDouble(ns());
	}

	static char nc() {
		return (char) skip();
	}

	static String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}

	static int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	static int ni() {
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

	static long nl() {
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

	static boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	static void tr(Object... o) {
		// if (!oj) {
		System.out.println(Arrays.deepToString(o));
		// }
	}
}
