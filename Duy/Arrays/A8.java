import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;

public class A8 {
	static final int INF = Integer.MAX_VALUE;
	static String INPUT = "5 " + "5 " + "14 " + "2 1 -1 2 5 8 9 1 2 3 3 3 2 1 "
			+ "4 " + "11 " + "3 2 1 -1 -1 -1 3 4 5 5 5 " + "20 " + "11 "
			+ "2 4 6 8 11 14 17 21 45 50 100 " + "1 " + "5 " + "1 1 1 1 1 "
			+ "-1 " + "5 " + "1 1 1 1 1 ";

	static final Modes mode = Modes.TEST;

	public static void main(String[] args) {
		generateTestCase(20, 1, 1000000);// run in mode test;
		setMode(mode);
		input();
		long s;
		for (int i = 0; i < nTestCases; i++) {
			s = System.currentTimeMillis();
			solve(a[i], ks[i]);
			tr(System.currentTimeMillis() - s + "ms");
		}

	}

	static void solve(int s[], int k) {
		int length = s.length;
		int maxLength = 0;
		int posMaxVal = 0;
		int posMinVal = 0;
		int maxVal = INF * -1;
		int minVal = INF;
		int pivotLeft = 0;
		int pivotRight = 0;
		int endPos = 0;

		for (int i = 0; i < length; i++) {
			if (s[i] > maxVal) {
				maxVal = s[i];
				posMaxVal = i;
			}
			if (s[i] < minVal) {
				minVal = s[i];
				posMinVal = i;
			}
			if (maxVal - minVal > k && posMaxVal < posMinVal) {
				pivotRight = posMinVal;
				if (pivotRight - pivotLeft > maxLength) {
					maxLength = pivotRight - pivotLeft;
					endPos = pivotRight - 1;
				}
				pivotLeft = posMaxVal + 1;
				while (pivotLeft < pivotRight
						&& s[pivotLeft] - s[pivotRight] > k) {
					pivotLeft++;
				}
				i = pivotLeft - 1;
				minVal = INF;
				maxVal = INF * -1;
			}

			if (maxVal - minVal > k && posMaxVal > posMinVal) {
				pivotRight = posMaxVal;
				if (pivotRight - pivotLeft > maxLength) {
					maxLength = pivotRight - pivotLeft;
					endPos = pivotRight - 1;
				}
				pivotLeft = posMinVal + 1;
				while (pivotLeft < pivotRight
						&& s[pivotRight] - s[pivotLeft] > k) {
					pivotLeft++;
				}
				i = pivotLeft - 1;
				minVal = INF;
				maxVal = INF * -1;
			}

			if (i == length - 1 && maxVal - minVal <= k) {
				pivotRight = length;
				if (pivotRight - pivotLeft > maxLength) {
					maxLength = pivotRight - pivotLeft;
					endPos = pivotRight - 1;
				}
			}
		}
		printArray(s, endPos - maxLength + 1, endPos);
	}

	/*********************************** INPUT *********************************************/

	static int nTestCases; // number of testcases
	static int[] n; // length of ith testcase
	static int[] ks;
	static int[][] a; // ith arrays

	static void input() {
		nTestCases = !mode.equals(Modes.CODEFORCES) ? nextInt() : 1;
		n = new int[nTestCases];
		ks = new int[nTestCases];
		a = new int[nTestCases][];
		for (int i = 0; i < nTestCases; i++) {
			ks[i] = nextInt();
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
		if (!mode.equals(Modes.CODEFORCES) && !mode.equals(Modes.ACM)) {
			System.out.println(Arrays.deepToString(o));
		}
	}

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
			break;
		case ACM:
			is = System.in;
			break;
		default:
			is = System.in;
			break;
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

	private static void generateTestCase(int nTestcase, int min, int max) {
		StringBuilder out = new StringBuilder();
		out.append(nTestcase + " ");
		for (int i = 0; i < nTestcase; i++) {
			int k = randomInt(min, max);
			int n = 1000000;
			out.append(k + " ");
			out.append(n + " ");
			for (int j = 0; j < n; j++) {
				out.append(randomInt(min, max) + " ");
			}
		}
		INPUT = out.toString();
	}

	private static int randomInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}
}