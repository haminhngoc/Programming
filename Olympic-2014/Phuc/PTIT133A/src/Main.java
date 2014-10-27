import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		int t = nextInt();
		for (int i = 1; i <= t; ++i) {
			System.out.print("Case #" + i + ": ");
			System.out.println(solve());
		}
	}

	private static long solve() {
		int n = nextInt();
		int k = nextInt();
		long a = nextLong();
		long b = nextLong();
		long c = nextLong();
		long r = nextLong();

		int arr[] = new int[k + 1];
		Arrays.fill(arr, -1);
		if (a < k) {
			arr[(int) a] = 0;
		}
		if (n == 1) {
			return a;
		}
		long m = a;
		for (int i = 1; i < k; ++i) {
			m = (b * m + c) % r;
			if (m <= k) {
				arr[(int) m] = i;
			}
			if (n - 1 == i) {
				return m;
			}
		}

		long result[] = new long[k + 1];
		Arrays.fill(result, -1);
		int index = 0;
		for (int i = 0; i < k; ++i) {
			if (result[i] >= 0) {
				continue;
			}
			while (arr[index] >= i) {
				int t = arr[index];
				result[t + 1] = index;
				index++;
			}
			result[i] = index++;
		}
		result[k] = index;
		int t = (n - k - 1) % (k + 1);
		return result[t];
	}

	public static InputStream in = System.in;
	public static byte[] bytes = new byte[1024];
	public static int lenbuf = 0;
	public static int ptrbuf = 0;

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

	public static String nextString2() {
		StringBuilder str = new StringBuilder();

		int b = readByte();
		while (!isSpace(b) || b == ' ') {
			str.appendCodePoint(b);
			b = readByte();
		}

		return str.toString();
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
