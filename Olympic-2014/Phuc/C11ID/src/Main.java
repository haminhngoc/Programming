import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) {
		int n = nextInt();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		long result = 1;
		for (int i = 0; i < n; ++i) {
			q.add(nextInt());
		}

		for (int i = 0; i < n; ++i) {
			result = (result * (q.poll() - i)) % 1000000007;
		}
		
		System.out.println(result);
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
