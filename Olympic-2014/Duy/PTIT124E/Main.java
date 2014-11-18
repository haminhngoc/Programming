import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

class PTIT124E {
	public static void main(String[] args) {
		solve();
	}

	static int n;
	static int m;
	static int k;
	static int[][] p;

	static void solve() {
		k = nextInt();
		n = nextInt();
		m = nextInt();
		int[] startAt = new int[k];
		for (int i = 0; i < k; i++) {
			startAt[i] = nextInt() - 1;
		}
		int[] from = new int[m];
		int[] to = new int[m];
		int[] size = new int[n];
		int[] curPos = new int[n];
		for (int i = 0; i < m; i++) {
			from[i] = nextInt() - 1;
			to[i] = nextInt() - 1;
			size[from[i]]++;
		}

		p = new int[n][];
		for (int i = 0; i < n; i++) {
			p[i] = new int[size[i]];
		}

		for (int i = 0; i < m; i++) {
			p[from[i]][curPos[from[i]]++] = to[i];
		}
		canVisit = new int[n];
		for (int i = 0; i < k; i++) {
			boolean[] label = new boolean[n];
			getRoad(startAt[i], label);
		}
		long res = 0;
		for (int i = 0; i < n; i++) {
			if (canVisit[i] == k) {
				res++;
			}
		}
		System.out.println(res);
	}

	static int[] canVisit;

	private static void getRoad(int cur, boolean[] label) {
		label[cur] = true;
		canVisit[cur]++;
		for (int i = 0; i < p[cur].length; i++) {
			if (!label[p[cur][i]]) {
				getRoad(p[cur][i], label);
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

