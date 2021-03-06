import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

class TPCDLCS {
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

	// Ref: https://github.com/haminhngoc/Programming/blob/master/Ngoc/BaseCode/ArrrayAlgorithms.java#LCS
	static void solve() {
		char[] s1 = ns().toCharArray();
		char[] s2 = ns().toCharArray();

		int[][] map = buildLCSMap(s1, s2);
		String[][][] cache = new String[s1.length + 1][s2.length + 1][];

		String[] result = readLCSAllResult(s1, s2, map, s1.length, s2.length, cache);

		Arrays.sort(result);

		System.out.println(result.length);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	static int[][] buildLCSMap(char[] s1, char[] s2) {
		int len1 = s1.length;
		int len2 = s2.length;

		int[][] map = new int[len1 + 1][len2 + 1];

		for (int i = 1; i <= len1; i++) {
			char c1 = s1[i - 1];
			for (int j = 1; j <= len2; j++) {
				if (c1 == s2[j - 1]) {
					map[i][j] = map[i - 1][j - 1] + 1;
				}
				else {
					map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
				}
			}
		}
		return map;
	}

	static String[] readLCSAllResult(char[] s1, char[] s2, int[][] map, int x, int y, String[][][] cache) {

		if (cache[x][y] != null) {
			return cache[x][y];
		}

		if (x == 0 || y == 0) {
			return null;
		}

		String[] result = null;
		if (s1[x - 1] == s2[y - 1]) {
			String[] preCache = readLCSAllResult(s1, s2, map, x - 1, y - 1, cache);

			if (preCache == null) {
				preCache = new String[] { "" };
			}

			result = cache[x][y] = new String[preCache.length];
			for (int i = 0; i < preCache.length; i++) {
				result[i] = preCache[i] + s1[x - 1];
			}

			return result;
		}

		String[] left = null, right = null;

		if (map[x - 1][y] >= map[x][y - 1]) {
			left = readLCSAllResult(s1, s2, map, x - 1, y, cache);
		}

		if (map[x - 1][y] <= map[x][y - 1]) {
			right = readLCSAllResult(s1, s2, map, x, y - 1, cache);
		}

		if (left != null && right != null && left != right) {
			result = unionTwoArray(left, right);
		}
		else {
			result = left != null ? left : right;
		}

		cache[x][y] = result;
		return result;
	}

	static String[] unionTwoArray(String[] s1, String[] s2) {
		int count = 0;
		String[] temp = new String[s2.length];

		for (int j = 0; j < s2.length; j++) {
			int i = 0;
			for (i = 0; i < s1.length; i++) {
				// Distinct location
				// if (s2[j] == s1[i]) {
				// break;
				// }

				// Disinct result
				if (s2[j].compareTo(s1[i]) == 0) {
					break;
				}
			}
			if (i == s1.length) {
				temp[count++] = s2[j];
			}
		}
		String[] result = new String[s1.length + count];
		for (int i = 0; i < count; i++) {
			result[i] = temp[i];
		}
		for (int i = 0; i < s1.length; i++) {
			result[count + i] = s1[i];
		}
		return result;
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
		if (!oj) {
			System.out.println(Arrays.deepToString(o));
		}
	}
}
