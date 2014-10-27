import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

class BINTREE {
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

	static int N;
	static int[] preorder;
	static int[] inorder;
	static int[] posorder;
	static int[] inorderMap;

	static void solve() {
		N = ni(); // 50K
		preorder = na(N);
		inorder = na(N);
		posorder = new int[N];

		inorderMap = new int[N + 1];
		for (int i = 0; i < N; i++) {
			inorderMap[inorder[i]] = i;
		}

		// convert(0, 0, 0, N);
		convertLoop();

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < N; i++) {
			builder.append(posorder[i] + " ");
		}

		System.out.println(builder.toString());
	}

	static private void convert(int preStart, int inStart, int posStart, int len) {
		if (len == 0) {
			return;
		}

		int nodeValue = preorder[preStart];
		int inPos = inorderMap[nodeValue];
		int leftLen = inPos - inStart;

		posorder[posStart + len - 1] = nodeValue;

		convert(preStart + 1, inStart, posStart, leftLen);
		convert(preStart + 1 + leftLen, inStart + leftLen + 1, posStart + leftLen, len - leftLen - 1);
	}

	static private void convertLoop() {
		Stack<Status> statuses = new Stack<BINTREE.Status>();
		statuses.push(new Status(0, 0, 0, N));
		while (!statuses.isEmpty()) {
			Status status = statuses.pop();
			if (status.len == 0) {
				continue;
			}
			int nodeValue = preorder[status.preStart];
			int inPos = inorderMap[nodeValue];
			int leftLen = inPos - status.inStart;

			posorder[status.posStart + status.len - 1] = nodeValue;

			if (leftLen > 0) {
				statuses.push(new Status(status.preStart + 1, status.inStart, status.posStart, leftLen));
			}
			if (status.len - leftLen - 1 > 0) {
				statuses.push(new Status(status.preStart + 1 + leftLen, status.inStart + leftLen + 1,
						status.posStart + leftLen, status.len - leftLen - 1));
			}
		}
	}

	static class Status
	{
		int preStart;
		int inStart;
		int posStart;
		int len;

		public Status(int preStart, int inStart, int posStart, int len) {
			this.preStart = preStart;
			this.inStart = inStart;
			this.posStart = posStart;
			this.len = len;
		}
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
