import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

class VOSEXP {
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

	static int rightSize = 0x100000; // 2^20
	static int rightFlag = 0xfffff;
	static int rightBit = 20;
	// 0, 1, 2..., 2^20-1
	static int[] rightCache = new int[rightSize];

	static int leftSize = 0x200000; // 2^21
	// A20 = 2^20. 0, A20, 2*A20...(2^21-1)*A20
	static int[] leftCache = new int[leftSize];

	/*
	 * The most expensive operator is % (Mod), the main challenge is how to minimize using Mod operator
	 * A^T = A^(2^20*TLeft + TRight) = A^(2^20*TLeft) * A^TRight 
	 * Idea: SQRT of Exponent (Ngoc) vs. SQRT of Multiply (very popular)
	 */
	static void solve() {
		int M = ni(); // 2*10^7
		long A = nl(); // 10^12
		long a = nl(); // 10^5
		long b = nl(); // 10^5
		long c = nl(); // 10^5
		long d = nl(); // 10^12
		long BASE = nl(); // 10^9

		A = A % BASE;
		long temp = 1;
		// ~ 100ms: cacheleft and cacheRight
		for (int i = 0; i < rightSize; i++) {
			rightCache[i] = (int) temp;
			temp = (temp * A) % BASE; // => temp <= 10^9, temp * A <= 10^18
		}
		long A20 = temp;
		temp = 1;
		for (int i = 0; i < leftSize; i++) {
			leftCache[i] = (int) temp;
			temp = (temp * A20) % BASE; // A20 <= 10^9
		}

		long T = a; // <= 10^12 < 2^41
		long F = 0;
		for (int i = 1; i <= M; i++) {
			int right = (int) (T & rightFlag);
			int left = (int) (T >> rightBit);
			F = (F + (long)rightCache[right] * leftCache[left]) % BASE; // Problem? Why or Why not?
			T = (T * b + c) % d;
		}
		
		// WHAT IS WRONG? DO I MISSUNDERSTAND THE PROBLEM? SMALL TESTCASES RETURN THE SAME VALUE AS MANUALTEST.XLSX!
		// UPDATED: A SILLY MISTAKE OF MULTIPLY INTEGERS
		out.println(F);
	}

	/*
	 * *****************************************************************
	 * ******************* BASIC READER *******************************
	 * ***************************************************************
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

/*
 * Some other ideas has been commented: Some of them can be used in other
 * problem For e.g If BASE, A, N <= 10^12, How to calculate A^N % BASE?
 * 
 * static long M2 = 0x100000; static long FM2 = 0xfffff; static int
 * powerBase(long A, long p, long BASE) { if (p < cacheSize) { return
 * powerCache[(int) p]; }
 * 
 * long result = powerBase(A, p >> 1, BASE); result = (result * result) % BASE;
 * 
 * if ((p & 0x1) == 1) { result = (result * A) % BASE; } return (int) result; }
 * 
 * // X <= 10^9 static long powerBaseInt(long X, long p, long BASE) { if (p ==
 * 1) { return X; }
 * 
 * long result = powerBaseInt(X, p >> 1, BASE); result = (result * result) %
 * BASE;
 * 
 * if ((p & 0x1) == 1) { result = (result * X) % BASE; } return result; }
 * 
 * // X, BASE <= 10^12 static long powerBaseLong(long X, long p, long BASE) { if
 * (p == 1) { return X; }
 * 
 * long result = powerBaseLong(X, p >> 1, BASE); result =
 * multiplyBaseLong(result, result, BASE);
 * 
 * if ((p & 0x1) == 1) { result = multiplyBaseLong(result, X, BASE); } return
 * result; }
 * 
 * // X, Y, BASE <= 10^12 static long multiplyBaseLong(long X, long Y, long
 * BASE) { long b1 = X >> 20; long b2 = X & FM2; // X = b1 * M2 + b2; // return
 * ((((M2 * Y) % BASE) * b1) % BASE + (b2 * Y) % BASE) % BASE; return (((M2 * Y)
 * % BASE) * b1 + b2 * Y) % BASE; // Will be OK too, why? }
 */