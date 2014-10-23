import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

class VOSHANDL {
	public static void main(String[] args) {
		solve();
	}

	static int[][] posChar;

	static void solve() {
		char[] s = nextString().toCharArray();
		int length = s.length;
		posChar = new int[length + 1]['z' - '.' + 1];
		for (int i = 1; i <= length; i++) {
			for (char letter = '.'; letter <= 'z'; letter++) {
				int j = letter - '.';
				int cur = s[i - 1] - '.';
				if (cur == j) {
					posChar[i][j] = i;
				} else {
					posChar[i][j] = posChar[i - 1][j];
				}

			}
		}

		int q = nextInt();
		StringBuilder ans = new StringBuilder();
		for (int i = 0; i < q; i++) {
			char[] firstName = nextString().toCharArray();
			char[] secondName = nextString().toCharArray();
			int pos1 = checkExist(firstName, length + 1);
			int pos2 = checkExist(secondName, length + 1);
			int res = -4;
			if (pos1 != -1 && pos2 != -1) {
				if (pos1 < pos2) {
					res = -1;
				} else if (pos1 > pos2) {
					res = -2;
				} else {
					res = -3;
				}
			}
			ans.append(res + "\n");

		}
		System.out.print(ans);
	}

	static int checkExist(char[] name, int cur) {
		int finalPos = cur;
		int n = name.length;
		for (int j = n - 1; j >= 0; j--) {
			if (cur == 0) {
				break;
			}
			cur = posChar[cur - 1][name[j] - '.'];
		}
		if (cur == 0) {
			return -1;
		}
		return posChar[finalPos - 1][name[n - 1] - '.'];
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

