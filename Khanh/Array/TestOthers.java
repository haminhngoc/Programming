import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class TestOthers {
	
	static String INPUT = "3\n" + "10\n" + "2 1 -1 2 5 8 9 1 2 3\n" + "5\n"
			+ "5 4 3 2 1\n" + "11\n" + "1 2 3 2 1 10 5 10 1000 10000 100000\n";
	
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

	static void solve(int k) {
		int[] s = a[k];
		int length = n[k];
		StringBuilder res = new StringBuilder();

		if (length == 1) {
			System.out.println(1);
			return;
		}

		int end = 0;
		int start = 0;
		int preEnd = -1;
		int nextstart = -1;
		int count = 0;
		int sum = 0;
		int sumLeft = 0;
		int max = 0;
		boolean check = false;
		int endRes = 0;

		for (int i = 0; i < length - 1; i++) {
			if (i == length - 2 && s[i] <= s[i + 1]) {// non decrease <= , otherwise <
				count++;
			}
			count++;
			if (s[i] > s[i + 1] || (i == length - 2 && s[i] <= s[i + 1])) { // non decrease <= , otherwise <
				sum = count;
				end = s[i];
				start = s[i + 1];
				preEnd = i - 1 >= 0 ? s[i - 1] : start;
				nextstart = i + 2 <= length - 1 ? s[i + 2] : end;

				if (check) {
					// max = Math.max(sum + sumLeft, max);
					if (sum + sumLeft > max) {
						max = sum + sumLeft;
						endRes = i;
						if(i == length - 2 && s[i] <= s[i + 1])// non decrease <= , otherwise <
						{
							endRes ++;
						}
					}
					check = false;
				}
				//if (start - preEnd > 1 || nextstart - end > 1) { 
				if(start>=preEnd || nextstart >= end){ //non decrease
					check = true;
					sumLeft = sum;
				}
				if (sum + 1 <= length) {
					sum += 1;

				}
				// max = Math.max(sum, max);
				if (sum > max) {
					max = sum;
					endRes = i;
					if((i == length - 2 && s[i] <= s[i + 1]) || (i - max + 1 < 0))// non decrease <= , otherwise <
					{
						endRes++;
					}
				}
				count = 0;
			}
		}
		for (int i = endRes - max + 1; i <= endRes; i++) {
			res.append(s[i] + " ");
		}
		//System.out.println(max);
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