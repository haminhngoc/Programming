import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		long a = 1;
		long count[] = new long[100001];
		count[100000] = 1;
		for (; a <= 50000; ++a) {
			Long z = a * a;
			for (long i = a; i >= 1; --i) {
				if (a % i == 0) {
					long j = (z / i);
					if ((i + j) % 2 == 0) {
						long c = (i + j) / 2;

						if (c % 2 == 0 || c > 100000) {
							continue;
						}
						if (c > 100000) {
							break;
						}
						int b = (int) (c - i);
						if (b <= a) {
							count[(int) c]++;
						}
					}
				}
			}
		}

		List<Integer> list = new ArrayList<Integer>();
		List<Long> list2 = new ArrayList<Long>();

		for (int i = 1; i <= 100000; i += 2) {
			if (count[i] != 1) {
				list.add(i);
				list2.add(count[i]);
			}

		}
		int t = nextInt();
		for (int i = 0; i < t; ++i) {
			int m = nextInt();
			int n = nextInt();
			long result = 0;
			int size = list.size();
			for (int j = 0; j < size; ++j) {
				int o = list.get(j);
				if (o > m && o > n) {
					break;
				}
				result += list2.get(j) * (m - o + 1) * (n - o + 1);
			}

			int min = Math.min(m, n);
			int max = Math.max(m, n);
			for (int j = 1; j <= min; ++j) {
				result += (min - i + 1) * (max - i + 1);
			}
			System.out.println(result);
		}

	}

	public static InputStream in = System.in;
	public static byte[] bytes = new byte[1000000];
	public static int lenbuf = 0;
	public static int ptrbuf = 0;

	public static boolean hasNext() {

		if (lenbuf <= 0) {
			return false;
		}
		for (int i = ptrbuf; i < lenbuf; ++i) {
			if (!isSpace(bytes[i])) {
				return true;
			}
		}
		return false;
	}

	public static int readByte() {
		if (lenbuf == -1) {
			throw new InputMismatchException();
		}
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = in.read(bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new InputMismatchException();
			}
			if (lenbuf <= 0) {
				return -1;
			}

		}

		return bytes[ptrbuf++];
	}

	public static boolean isSpace(int b) {
		return !(b >= 33 && b <= 126);
	}

	public static int read() {
		int b;
		while ((b = readByte()) != -1 && isSpace(b))
			;
		return b;
	}

	public static char nextChar() {
		return (char) read();
	}

	public static String nextString() {
		StringBuilder str = new StringBuilder();

		int b = read();
		while (!isSpace(b)) {
			str.appendCodePoint(b);
			b = readByte();
		}

		return str.toString();
	}

	public static int nextInt() {
		return Integer.parseInt(nextString());
	}

	public static long nextLong() {
		return Long.parseLong(nextString());
	}
}