import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		int m = nextInt();
		int n = nextInt();
		Integer[] arr = new Integer[n];

		for (int i = 0; i < n; ++i) {
			arr[i] = nextInt();
		}

		Arrays.sort(arr);
		int max = 0;
		int p = n;
		for (int i = n - 1; i >= 0 && i >= n - m; --i) {
			if (arr[i] * ((n - i) > m ? m : n - i) >= max) {
				p = i;
				max = arr[i] * ((n - i) > m ? m : n - i);
			}
		}

		System.out.println(arr[p] + " " + arr[p] * ((n - p) > m ? m : n - p));
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
