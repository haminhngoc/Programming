import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int n = nextInt();

		int k = nextInt();

		List<Integer> listPrime = generatePrimes(n);
		
		System.out.println(0);
	}

	private static List<Integer> generatePrimes(int n) {
		List<Integer> list = new ArrayList<Integer>();
		int size = 1;
		list.add(2);

		for (int i = 3; size < n; ++i) {
			int end = (int) Math.sqrt(i);
			int j;
			for (j = 0; j < size && list.get(j) <= end; ++i) {
				if (i % list.get(j) == 0) {
					break;
				}

				if (j < size && i % list.get(j) == 0) {
					continue;
				} else {
					list.add(i);
					size++;
				}
			}
		}
		return list;
	}

	public static InputStream in = System.in;
	public static byte[] bytes = new byte[1024];
	public static int lenbuf = 0;
	public static int ptrbuf = 0;

	private static int readByte() {
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

	private static boolean isSpace(int b) {
		return !(b >= 33 && b <= 126);
	}

	private int read() {
		int b;
		while ((b = readByte()) != -1 && isSpace(b))
			;
		return b;
	}

	private char nextChar() {
		return (char) read();
	}

	private static String nextString() {
		StringBuilder str = new StringBuilder();
		int b = readByte();
		while (!isSpace(b)) {
			str.appendCodePoint((b));
			b = readByte();
		}

		return str.toString();
	}

	private static int nextInt() {
		return Integer.parseInt(nextString());
	}

	private long nextLong() {
		return Long.parseLong(nextString());
	}
}
