import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

class Main {
	public static int arr[];
	public static int temp[] = new int[1000];
	public static int maxPos;

	public static void main(String[] args) {
		int n = nextInt();
		arr = new int[n];

		arr[0] = nextInt();
		temp[0] = nextInt();

		maxPos = 0;
		long result = 0;

		for (int i = 0; i < n; ++i) {
			arr[i] = nextInt();
			int g = i >> 9;
			result += find(i);

			if (arr[i] > temp[g]) {
				temp[g] = arr[i];
				if (arr[maxPos] < temp[g]) {
					maxPos = i;
				}
			}
		}

		System.out.println(result);

	}

	private static long find(int i) {
		int g = i >> 9;

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

class P {
	public int value;
	public int po;
}
