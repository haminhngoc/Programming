import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class A6 {

	static String INPUT = "3\n" + "10\n" + "2 1 -1 2 5 8 9 1 2 3\n" + "11\n"
			+ "1 2 3 2 1 -9 5 10 1000 10000 100000\n" + "11\n" + "1 2 3 2 1 -10 5 10 1000 10000 100000\n";

	public static void main(String[] args) {
		oj = true; // Fasle to run 3 testcases, True to type input.
		is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		input();
		long s = System.currentTimeMillis();
		for (int i = 0; i < nTestCases; i++) {
			solve(i);
		}
		tr(System.currentTimeMillis() - s + "ms");

	}

	static void solve(int k) {
		int[] s = a[k];
		int length = n[k];
		StringBuilder res = new StringBuilder();

		if (length == 1) {
			System.out.println(s[0]);
			return;
		}

		int[] sums = new int[length + 1];
		sums[0] = 0;
		for (int i = 0; i < length; i++) {
			sums[i + 1] = s[i] + sums[i];
		}

		int min = sums[0];
		int max = Integer.MIN_VALUE;
		int sum = 0;
		int posMin = 0;
		int posMax = 0;
		int tempPos = 0;
		for (int i = 1; i < sums.length; i++) {
			if (sums[i - 1] < min) {
				min = sums[i - 1];
				tempPos = i - 1;
			}

			sum = sums[i] - min;
			if (sum > max) {
				max = sum;
				posMin = tempPos;
				posMax = i;
			}
		}
		for (int i = posMin; i <= posMax - 1; i++) {
			res.append(s[i] + " ");
		}
		System.out.println(res);
	}

	/*********************************** INPUT *********************************************/

	static int nTestCases; // number of testcases
	static int[] n; // length of ith testcase
	static int[][] a; // ith arrays

	static void input() {
		nTestCases = nextInt();
		n = new int[nTestCases];
		a = new int[nTestCases][];
		for (int i = 0; i < nTestCases; i++) {
			n[i] = nextInt();
			a[i] = nextAi(n[i]);
		}
	}

	/******************************** BASIC READER ***************************************/
	static InputStream is = System.in;
	static private byte[] buffer = new byte[1024];
	static private int lenbuf = 0, ptrbuf = 0;

	static private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(buffer);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return buffer[ptrbuf++];
	}

	static private boolean isSpace(int c) {
		return !(c >= 33 && c <= 126);
	}

	static private int read() {
		int b;
		while ((b = readByte()) != -1 && isSpace(b))
			;
		return b;
	}

	static private double nextDouble() {
		return Double.parseDouble(nextString());
	}

	static private char nextChar() {
		return (char) read();
	}

	static private String nextString() {
		int b = read();
		StringBuilder sb = new StringBuilder();
		while (!(isSpace(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static private char[] nextString(int n) {
		char[] buf = new char[n];
		int b = read(), p = 0;
		while (p < n && !(isSpace(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
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

	private long nextLong() {
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

	static private int[] nextAi(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	static boolean oj = System.getProperty("ONLINE_JUDGE") != null;

	static void tr(Object... o) {
		if (!oj) {
			System.out.println(Arrays.deepToString(o));
		}
	}
}