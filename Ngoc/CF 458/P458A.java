import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class P458A {
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

	static void solve() {
		String s1 = ns();
		String s2 = ns();

		int len1 = s1.length();
		int len2 = s2.length();
		int maxLen = Math.max(len1, len2);
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int d1 = maxLen - c1.length;
		int d2 = maxLen - c2.length;

		for (int i = 0; i < maxLen; i++) {
			if (i - d1 >= 0 && i - d2 >= 0 && c1[i - d1] == c2[i - d2]) {
				c1[i - d1] = '0';
				c2[i - d2] = '0';
			}
		}

		int i = 0, j = 0;

		char result = '=';
		while (i < len1 && j < len2) {
			while (i < len1 && c1[i] == '0')
				i++;
			while (j < len2 && c2[j] == '0')
				j++;
			int r1 = len1 - i;
			int r2 = len2 - j;
			if (r1 < r2 - 1) {
				result = '<';
				break;
			}
			if (r1 - 1 > r2) {
				result = '>';
				break;
			}

			if (r1 == r2) { // == 0
				break;
			}

			if (r1 > r2) { // r1 = r2 + 1
				if (r2 > 1 && c2[j + 1] == '1') {
					i += 3;
					j += 2;
				} else if (r2 > 1 && c2[j + 1] == '0' && c1[i + 2] == '0') {
					c1[i + 2] = '1';
					i += 2;
					j += 1;
				} else {
					result = '>';
					break;
				}
			} else { // r1 + 1 = r2
				if (r1 > 1 && c1[i + 1] == '1') {
					j += 3;
					i += 2;
				} else if (r1 > 1 && c1[i + 1] == '0' && c2[j + 2] == '0') {
					c2[j + 2] = '1';
					j += 2;
					i += 1;
				} else {
					result = '<';
					break;
				}
			}
		}

		System.out.println(result);

	}

	/*****************************************************************
	 ******************** BASIC READER *******************************
	 *****************************************************************/

	static byte[] inbuf = new byte[1024];
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
