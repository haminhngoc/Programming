import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		long x = nextLong();
		long y = nextLong();

		long t = 0;
		long m1 = 20000;
		long m2 = 20000 + (10000 - 100) * 300;
		long m3 = m2 + (1000000 - 10000) * 500;

		if (x <= m1) {
			t = (x / 200);
		} else if (x <= m2) {
			t = ((x - m1) / 300 + 100);
		} else if (x <= m3) {
			t = ((x - m2) / 500 + 10000);
		} else {
			t = (x - m3) / 700 + 1000000;
		}

		long i = 0;
		while (true) {
			
			long N = cal(i);
			long M = cal(t);
			if(-N+M==y){
				System.out.println(N);
				return;
			}
			i++;
			t--;
		}

	}

	private static long cal(long v) {
		long r = 0;
		if (v <= 100) {
			r += v * 200;
			return r;
		}
		r = 20000;
		if (v <= 10000) {
			r += (v - 100) * 300;
			return r;
		}
		r += (10000 - 100) * 300;
		if (v <= 1000000) {
			r += (v - 10000) * 500;
			return r;
		}
		r += (1000000 - 10000) * 500;
		r += (v - 1000000) * 700;
		return r;
	}

	public static InputStream in = System.in;
	public static byte[] bytes = new byte[1024];
	public static int lenbuf = 0;
	public static int prtbuf = 0;

	public static int readByte() {
		if (lenbuf == -1) {
			throw new InputMismatchException();
		}
		if (prtbuf >= lenbuf) {
			prtbuf = 0;
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

		return bytes[prtbuf++];
	}

	public static int read() {
		int b;
		while ((b = readByte()) != -1 && isSpace(b))
			;
		return b;

	}

	private static boolean isSpace(int b) {
		return !(b >= 33 && b <= 126);

	}

	private static String nextString() {
		StringBuilder str = new StringBuilder();
		int b = read();
		while (!isSpace(b)) {
			str.appendCodePoint(b);
			b = readByte();
		}
		return str.toString();
	}

	private static int nextInt() {
		return Integer.parseInt(nextString());
	}

	private static long nextLong() {
		return Long.parseLong(nextString());
	}

}
