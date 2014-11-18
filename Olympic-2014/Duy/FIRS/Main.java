import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

class FIRS {
	public static void main(String[] args) {
		solve();
	}

	static Integer[] a;
	static Integer[] pos;

	static void solve() {
		int n = nextInt();
		if (n == 1) {
			System.out.println(1);
			return;
		}
		a = new Integer[n];
		pos = new Integer[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
			pos[i] = i;
		}
		Arrays.sort(pos, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return a[o1] - a[o2];
			}
		});
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (a[pos[i]] != -1) {
				res++;
				a[pos[i]] = -1;

				if (pos[i] == 0) {
					a[pos[i] + 1] = -1;
					continue;
				}
				if (pos[i] == n - 1) {
					a[pos[i] - 1] = -1;
					continue;
				}

				a[pos[i] - 1] = -1;
				a[pos[i] + 1] = -1;
			}
		}
		System.out.println(res);
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

