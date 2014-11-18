import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

class PTIT133A {
	public static void main(String[] args) {
		solve();
	}

	static void solve() {
		int test = nextInt();
		for (int id = 1; id <= test; id++) {
			long n = nextLong();
			long k = nextLong();
			long a = nextLong();
			long b = nextLong();
			long c = nextLong();
			long r = nextLong();

			long[] m = new long[(int) k];
			int[] numb = new int[(int) k + 1];
			long[] cons = new long[(int) k + 1];
			m[0] = a;
			if (a <= k) {
				numb[(int) a]++;
			}
			for (int i = 1; i < k; i++) {
				m[i] = (b * m[i - 1] + c) % r;
				if (m[i] <= k) {
					numb[(int) m[i]]++;
				}
			}
			PriorityQueue<Long> next = new PriorityQueue<Long>();
			for (int i = 0; i <= k; i++) {
				if (numb[i] == 0) {
					next.add((long) i);
				}
			}
			int nex = 0;
			while (next.size() <= k) {
				next.add(k + nex);
				nex++;
			}
			int index = 0;
			while (index <= k) {
				cons[index] = next.poll();
				if (index < k && m[index] <= k && numb[(int) m[index]] != 0) {
					numb[(int) m[index]]--;
					if (numb[(int) m[index]] == 0)
						next.add(m[index]);
				}
				index++;
			}
			int tmp = (int) (n % k - (n / k) % (k + 1));
			int pos = tmp < 0 ? (int) (k + 1 + tmp) : tmp;
			long res = cons[pos];
			System.out.printf("Case #%d: %d\n", id, res);
		}
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

