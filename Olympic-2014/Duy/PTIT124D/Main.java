import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

class PTIT124D {
	public static void main(String[] args) {
		solve();
	}

	static void solve() {
		int n;
		while ((n = nextInt()) != 0) {
			int type = nextInt();
			if (type == 1) {
				int a[] = new int[n];
				a = nextAi(n);
				System.out.println(getNth(a));
			} else {
				long nth = nextLong();
				long[] res = getPermu(nth - 1, n - 1);
				System.out.println(getString(res));
			}
		}
	}

	private static String getString(long[] res) {
		int n = res.length;
		StringBuilder sb = new StringBuilder();
		int[] pos = new int[n];
		int[] val = new int[n];
		for (int i = 0; i < n; i++) {
			val[i] = i + 1;
			pos[i] = i;
		}
		for (int i = 0; i < n - 1; i++) {
			sb.append((val[pos[(int) res[i]]]) + " ");
			for (int j = (int) res[i]; j < n - 1; j++) {
				val[j] = val[j + 1];
			}
		}
		sb.append(val[pos[(int) res[n - 1]]]);
		return sb.toString();
	}

	private static long[] getPermu(long nth, int max) {
		int index = 0;
		long[] permu = new long[(int) (max + 1)];
		while (nth % fact(max) != 0) {
			permu[index] = nth / fact(max);
			nth %= fact(max);
			max--;
			index++;
		}
		if (nth % fact(max) == 0) {
			permu[index++] = nth / fact(max);
		}
		return permu;
	}

	private static long getNth(int[] a) {
		int n = a.length;
		int[] pos = new int[n];
		for (int i = 0; i < n; i++) {
			pos[i] = i;
		}
		int[] factoradic = new int[n];
		int index = 0;
		for (int i = 0; i < n; i++) {
			factoradic[index++] = pos[a[i] - 1];
			for (int j = a[i] - 1; j < n; j++) {
				pos[j]--;
			}
		}
		long nTh = 0;
		for (int i = index - 1, j = 0; i >= 0; i--, j++) {
			nTh += (long) factoradic[i] * fact(j);
		}
		return nTh + 1;
	}

	private static long fact(int n) {
		if (n == 0) {
			return 1;
		}
		long fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
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

