import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class MagicFormulas {

	public static void main(String[] args) throws IOException {
		is = System.in;
		//Init(System.in);
		int n = ni();
		// int temp = nextInt();
		int[] arr = new int[n];
		// long result = temp ^ xor(0, n);// temp ^ 0;
		arr[0] = 0;

		for (int i = 1; i < n; ++i) {
			arr[i] = arr[i - 1] ^ i;
		}
		long result = 0;
		int temp;
		for (int i = 1; i <= n; ++i) {
			temp = ni();
			if (i == 1) {
				result = temp;
			} else {
				result ^= temp;
			}
			result = result ^ xor(arr[i - 1], n / i);
			if (n % i != 0 && i > 1) {
				result ^= arr[n % i];
			}
		}

		System.out.println(result);
	}

	public static int xor(int value, int repeatTimes) {
		if (repeatTimes % 2 == 1) {
			return value;
		}
		/*
		 * int temp = (repeatTimes - 2) % 4; if (temp == 0) { return 0; } else
		 * if (temp == 1) { return 0 ^ value; } else if (temp == 2) { return 1;
		 * } else { return 1 ^ value; }
		 */
		return 0;
	}

	/*
	 * static BufferedReader reader; static StringTokenizer tokenizer;
	 * 
	 * static void Init(InputStream input) { reader = new BufferedReader(new
	 * InputStreamReader(input)); tokenizer = new StringTokenizer(""); }
	 * 
	 * static String next() throws IOException { while
	 * (!tokenizer.hasMoreTokens()) { tokenizer = new
	 * StringTokenizer(reader.readLine()); } return tokenizer.nextToken(); }
	 * 
	 * static int nextInt() throws IOException { return
	 * Integer.parseInt(next()); }
	 * 
	 * static long nextLong() throws IOException { return
	 * Long.parseLong(next()); }
	 */

	static InputStream is;
	static private byte[] inbuf = new byte[1024];
	static private int lenbuf = 0, ptrbuf = 0;

	static private int readByte() {
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

	static private boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static private int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static private double nd() {
		return Double.parseDouble(ns());
	}

	static private char nc() {
		return (char) skip();
	}

	static private String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) { // when nextLine, (isSpaceChar(b) && b !=
									// ' ')
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static private char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static private char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}

	static private int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = ni();
		return a;
	}

	static private int ni() {
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

	private long nl() {
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

}
