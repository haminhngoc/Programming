import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

class KVIP {
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
		int N = ni();

		int[][] satisfies = new int[N][];
		for (int i = 0; i < N; i++) {
			satisfies[i] = na(N);
		}

		long[] sums = new long[N];
		long pre = 0;
		for (int i = 0; i < N; i++) {
			pre += satisfies[i][i];
			sums[i] = pre;
		}

		// MaxValues before each position can make choice (their seat is not available anymore)
		long[] massMaxValues = new long[N];
		massMaxValues[0] = 0; // Do not care
		for (int i = 1; i < N; i++) {
			massMaxValues[i] = 0;
			for (int j = 0; j < i; j++) {
				// When j make a choice to i => (j,i-1] will be in right position
				massMaxValues[i] = Math.max(massMaxValues[i], massMaxValues[j] + sums[i - 1] - sums[j] + satisfies[j][i]);
			}
		}

		long result = 0;
		for (int i = 0; i < N; i++) {
			// When i make a choice to 0, and let every one behind in the right position
			result = Math.max(result, massMaxValues[i] + satisfies[i][0] + sums[N-1] - sums[i]);
		}
		
		System.out.println(result);
	}

	/*
	 * *****************************************************************
	 * ******************* BASIC READER ******************************* ***************************************************************
	 */

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
