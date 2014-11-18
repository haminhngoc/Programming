import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

class BILL {
	public static void main(String[] args) {
		solve();
	}

	static long[] prices;
	static long[] cost;
	static long[] max;

	static void solve() {
		long x = nextLong();
		long y = nextLong();

		prices = new long[] { 100 * 200, 100 * 200 + 9900 * 300,
				100 * 200 + 9900 * 300 + 990000 * 500 };
		max = new long[] { 0, 100, 9900, 990000 };
		long kWh = 0;

		if (x <= prices[0]) {
			kWh = x / 200;
		} else if (x <= prices[1]) {
			kWh = (x - prices[0]) / 300 + max[1];
		} else if (x <= prices[2]) {
			kWh = (x - prices[1]) / 500 + max[2] + max[1];
		} else {
			kWh = (x - prices[2]) / 700 + max[3] + max[2] + max[1];
		}

		long res = calMoney(kWh, y);
		System.out.println(res);
	}

	private static long calMoney(long kWh, long y) {
		for (int i = 0; i <= kWh / 2; i++) {
			long n = i;
			long v = kWh - i;

			if (money(v) - money(n) == y) {
				return money(n);
			}
		}
		return 0;
	}

	private static long money(long n) {
		long money = 0;
		if (n <= 100) {
			money = n * 200;
		} else if (n <= 10000) {
			money = 100 * 200 + (n - 100) * 300;
		} else if (n <= 1000000) {
			money = 100 * 200 + 9900 * 300 + (n - 10000) * 500;
		} else {
			money = 100 * 200 + 9900 * 300 + 990000 * 500 + (n - 1000000) * 700;
		}
		return money;
	}

	/*****************************************************************
	 ******************** BASIC READER *******************************
	 *****************************************************************/

	static InputStream is = System.in;
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

	static private double nextDouble() {
		return Double.parseDouble(nextString());
	}

	static private char nextChar() {
		return (char) skip();
	}

	static private String nextString() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static private char[] nextString(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static private int[][] nextMatrix(int n, int m) {
		int[][] map = new int[n][];
		for (int i = 0; i < n; i++)
			map[i] = nextAi(n);
		return map;
	}

	static private int[] nextAi(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	static private Integer[] nextAI(int n) {
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
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
}

