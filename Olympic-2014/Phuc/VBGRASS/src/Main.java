import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		int r = nextInt();
		int c = nextInt();
		char[][] arr = new char[r][c];

		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				arr[i][j] = nextChar();
			}
		}
		solve(arr, r, c);

	}

	private static void solve(char arr[][], int r, int c) {
		int[][] re = new int[r][c];
		int val = 0;
		for (int i = 0; i < r; ++i) {
			for (int j = 0; j < c; ++j) {
				if (arr[i][j] == '#' && re[i][j] == 0) {
					val++;
					re[i][j] = val;
					dfs(arr, r, c, val, re, i, j);
				}
			}
		}
		System.out.println(val);
		
	}

	private static void dfs(char[][] arr, int r, int c, int val, int[][] re,
			int i, int j) {
		if (i + 1 < r && arr[i + 1][j] == '#' && re[i + 1][j] == 0) {
			re[i + 1][j] = val;
			dfs(arr, r, c, val, re, i + 1, j);
		}
		if (j + 1 < c && arr[i][j + 1] == '#' && re[i][j + 1] == 0) {
			re[i][j + 1] = val;
			dfs(arr, r, c, val, re, i, j + 1);
		}
		if (j - 1 >= 0 && arr[i][j - 1] == '#' && re[i][j - 1] == 0) {
			re[i][j - 1] = val;
			dfs(arr, r, c, val, re, i, j - 1);
		}
		if (i - 1 >=0 && arr[i - 1][j] == '#' && re[i - 1][j] == 0) {
			re[i - 1][j] = val;
			dfs(arr, r, c, val, re, i - 1, j);
		}

	}

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

	static private long nextLong() {
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

	static private Integer[] nextAi1(int n) {
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}
}
