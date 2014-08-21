/**
 * 
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

/**
 * @author duy
 * 
 */
public class A1 {
	static String INPUT = "3 " + "10 " + "2 1 -1 2 5 8 9 1 2 3 " + "5 "
			+ "5 4 3 2 1 " + "10 " + "1 2 3 2 1 10 100 1000 10000 100000 ";

	public enum Modes {
		TEST, CODEFORCES, ACM;
	};

	static public void setMode(Modes mode) {
		switch (mode) {
		case TEST:
			is = new ByteArrayInputStream(INPUT.getBytes());
			break;
		case CODEFORCES:
			is = System.in;
			oj = true;
			break;
		case ACM:
			is = System.in;
			isACM = true;
			break;
		default:
			System.out.println("This mode is not available ! ");
		}
	}

	public static void main(String[] args) {
		setMode(Modes.TEST);
		input();
		long s = 0;
		for (int i = 0; i < nTestCases; i++) {
			s = System.currentTimeMillis();
			solve(a[i]);
			tr(System.currentTimeMillis() - s + " ms");
		}
	}

	static void solve(int s[]) {
		int max = 1;
		int pos = 0;
		int end = 0;
		int length = s.length;
		int val = 0;

		for (int i = 0; i < length - 1; i++) {
			val = i - pos + 1;

			if (i == length - 2 && s[i] <= s[i + 1]) {
				val++;
			}

			if (s[i] > s[i + 1] || i == length - 2) {
				if (val > max) {
					max = val;
					end = i == length - 2 ? i + 1 : i;
				}
				pos = i + 1;
			}
		}
		printArray(s, end - max + 1, end);
	}

	/*********************************** INPUT *********************************************/
	static int nTestCases = 1; // number of testcases
	static int[] n; // length of ith testcase
	static int[][] a; // ith arrays

	static void input() {
		nTestCases = !oj ? nextInt() : 1;
		n = new int[nTestCases];
		a = new int[nTestCases][];
		for (int i = 0; i < nTestCases; i++) {
			n[i] = nextInt();
			a[i] = nextAi(n[i]);
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
	static boolean isACM = false;

	static void tr(Object... o) {
		if (!oj && !isACM) {
			System.out.println(Arrays.deepToString(o));
		}
	}

	/***************************************************************************************/

	static void printArray(int[] a, int start, int end) {
		int[] subArray = Arrays.copyOfRange(a, start, end + 1);
		printArray(subArray);
	}

	static void printArray(int[] a) {
		int length = a.length;
		StringBuilder out = new StringBuilder();
		for (int i = 0; i < length; i++) {
			out.append(a[i] + " ");
		}
		System.out.println(out);
	}
}
