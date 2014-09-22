import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class A7 {

	static String INPUT = "3\n" + "5 7\n" + "10\n" + "2 1 -1 2 5 8 9 1 2 3\n"
			+ "2 3\n" + "11\n" + "1 2 3 2 1 -9 5 10 1000 10000 100000\n"
			+ "6 7\n" + "11\n" + "5 5 5 5 5 5 5 5 5 5 5\n";

	public static void main(String[] args) {
		oj = false; // Fasle to run 3 testcases, True to type input.
		is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		input();
		long s = System.currentTimeMillis();
		for (int i = 0; i < nTestCases; i++) {
			solve(i);
		}
		tr(System.currentTimeMillis() - s + "ms");

	}

	static final int INF = Integer.MIN_VALUE;

	static void solve(int k) {
		int[] s = a[k];
		int length = n[k];
		int right = Math.max( k1[k], k2[k]);
		int left = Math.min(k1[k], k2[k]);
		int count = 0;
		int max = s[0];
		int maxLength = 0;
		int pos = 0;
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < length; i++) {
			if(s[i] <= right)
			{
				count++;
				max = Math.max(s[i], max);
			}
			if (s[i] > right || i == length - 1) {
				if (max >= left && max <= right) {
					//maxLength = Math.max(maxLength, count);
					if(maxLength < count)
					{
						maxLength = count;
						pos = i - 1;
						if (i == length - 1) {
							pos++;
						}
					}
					
				}
				count = 0;
				max = INF;
			}
		}
		if (maxLength == 0) {
			System.out.println("n/a");
			return;
		}
		for (int i = pos - maxLength +1 ; i < maxLength; i++) {
			res.append(s[i] + " ");
		}
		System.out.println(maxLength);
		System.out.println(res);
	}

	/*********************************** INPUT *********************************************/

	static int nTestCases; // number of testcases
	static int[] n; // length of ith testcase
	static int[] k1;
	static int[] k2;
	static int[][] a; // ith arrays

	static void input() {
		nTestCases = nextInt();
		n = new int[nTestCases];
		k1 = new int[nTestCases];
		k2 = new int[nTestCases];
		a = new int[nTestCases][];
		for (int i = 0; i < nTestCases; i++) {
			k1[i] = nextInt();
			k2[i] = nextInt();
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