import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

import org.omg.CORBA.NVList;

class PTIT124B {
	public static void main(String[] args) {
		solve();
	}

	static String[][] pattern;

	static void solve() {
		pattern = getPattern();
		int n = nextInt();
		for (int id = 1; id <= n; id++) {
			int r = nextInt();
			int c = nextInt();
			char[] s = nextString().toCharArray();
			System.out.println(id + " " + convert(s, r, c));
		}
	}

	private static String convert(char[] s, int r, int c) {
		int[][] a = new int[r][c];
		int index = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				a[i][j] = s[index++] - '0';
			}
		}
		String finalString = deCodeMatrix(a, r, c);
		return finalString;
	}

	private static String deCodeMatrix(int[][] a, int n, int m) {
		boolean[][] label = new boolean[n][m];
		int i = 0;
		int j = 0;
		int cnt = 1;
		StringBuilder sb = new StringBuilder();
		sb.append(a[0][0]);
		label[0][0] = true;
		while (cnt < n * m) {
			while (j + 1 < m && !label[i][j + 1]) {
				label[i][j + 1] = true;
				sb.append(a[i][j + 1]);
				cnt++;
				j++;
			}
			while (i + 1 < n && !label[i + 1][j]) {
				label[i + 1][j] = true;
				sb.append(a[i + 1][j]);
				cnt++;
				i++;
			}

			while (j - 1 >= 0 && !label[i][j - 1]) {
				label[i][j - 1] = true;
				sb.append(a[i][j - 1]);
				cnt++;
				j--;
			}
			while (i - 1 >= 0 && !label[i - 1][j]) {
				label[i - 1][j] = true;
				sb.append(a[i - 1][j]);
				cnt++;
				i--;
			}
		}
		String str = getString(sb.toString().toCharArray());
		return str;
	}

	private static String getString(char[] s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length - 4; i += 5) {
			String tmp = s[i] + "" + s[i + 1] + "" + s[i + 2] + "" + s[i + 3]
					+ "" + s[i + 4];
			for (int j = 0; j < 27; j++) {
				if (tmp.equals(pattern[0][j])) {
					sb.append(pattern[1][j]);
				}
			}
		}
		return sb.toString();
	}

	private static String[][] getPattern() {
		String[][] s = new String[2][27];
		for (int i = 0; i <= 26; i++) {
			s[1][i] = "";
		}
		for (int i = 0; i <= 26; i++) {
			s[0][i] = convertHexToBi(i);
			if (i == 0) {
				s[1][i] = " ";
			} else {
				s[1][i] += (char) ('A' + i - 1);
			}
		}
		return s;
	}

	private static String convertHexToBi(int i) {
		StringBuilder sb = new StringBuilder();
		while (i / 2 != 0) {
			sb.append(i % 2);
			i /= 2;
		}
		if (i == 1) {
			sb.append(1);
		}
		while (sb.length() < 5) {
			sb.append(0);
		}

		sb.reverse();
		return sb.toString();
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

