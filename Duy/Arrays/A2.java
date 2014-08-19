import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

public class A2 {
	static String INPUT = "3\n" + "10\n" + "2 1 -1 2 5 8 9 -1 2 3\n" + "5\n"
			+ "-5 4 3 2 -1\n" + "11\n"
			+ "-1 2 3 2 1 -10 100 1000 10000 100000 1000000\n";

	public static void main(String[] args) {
		oj = true; // Fasle to run 3 testcases, True to type input.
		is = oj ? System.in : new ByteArrayInputStream(INPUT.getBytes());
		input();
		long s = System.currentTimeMillis();
		solve();
		tr(System.currentTimeMillis() - s + "ms");
	}

	static void solve() {
		int max;
		int count;
		int end;
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < nTestCases; i++) {
			max = 0;
			count = 0;
			end = 0;
			if (n[i] == 1) {
				res.append(a[i][0] + "\n");
				continue;
			}
			for (int j = 0; j <= n[i]; j++) {
				if (a[i][j] < 0) {
					if (count > max) {
						max = count;
						end = j - 1;
					}
					count = 0;
				}
				else
				{
					count++;
				}
			}
			if(max == 0)
			{
				System.out.println("n/a");
				return;
			}
			for (int j = end - max + 1; j <= end; j++) {
				res.append(a[i][j] + " ");
			}
			res.append("\n");
		}
		System.out.println(res);
	}

	/*********************************** INPUT *********************************************/
	static int nTestCases; // number of testcases
	static int[] n; // length of ith testcase
	static int[][] a; // ith array

	static void input() {
		nTestCases = nextInt();
		n = new int[nTestCases];
		a = new int[nTestCases][];
		for (int i = 0; i < nTestCases; i++) {
			n[i] = nextInt();
			a[i] = new int[n[i] + 1];
			a[i][n[i]] = -1;
			for (int j = 0; j < n[i]; j++) {
				a[i][j] = nextInt();
			}
		}
	}

	/******************************** BASIC READER ***************************************/
	static InputStream is;
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
