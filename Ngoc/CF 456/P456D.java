import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class P456D {
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
		int CHARCOUNT = 'z' - 'a' + 1;
		int MAX = 100001; // 10^5 + 1
		int n = ni();
		int k = ni();

		int[][] tree = new int[MAX][CHARCOUNT];
		int nodeCount = 0;

		for (int i = 0; i < n; i++) {
			String s = ns();
			int sLen = s.length();
			int curNode = 0;
			for (int j = 0; j < sLen; j++) {
				int c = s.charAt(j) - 'a';
				if (tree[curNode][c] == 0) {
					tree[curNode][c] = ++nodeCount;
				}
				curNode = tree[curNode][c];
			}
		}

		boolean[] canWin = new boolean[MAX + 1];
		boolean[] canLose = new boolean[MAX + 1];
		int branchCount = 0;
		int cantWinCount = 0;
		int cantLoseCount = 0;
		for (int i = nodeCount; i >= 0; i--) {
			cantWinCount = 0;
			cantLoseCount = 0;
			branchCount = 0;
			for (int j = 0; j < CHARCOUNT; j++) {
				int next = tree[i][j];
				if (next > 0) {
					branchCount++;
					if (!canWin[next])
						cantWinCount++;
					if (!canLose[next])
						cantLoseCount++;
				}
			}
			if (branchCount == 0)
				canLose[i] = true;
			if (cantWinCount > 0)
				canWin[i] = true;
			if (cantLoseCount > 0)
				canLose[i] = true;
		}

		String result = "";
		String first = "First";
		String second = "Second";

		if (canWin[0] && canLose[0]) {
			result = first;
		} else if (canWin[0]) { // !canLose[0]
			result = k % 2 == 0 ? second : first;
		} else { // canLose[0] && !canWin[0]
			result = second;
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
