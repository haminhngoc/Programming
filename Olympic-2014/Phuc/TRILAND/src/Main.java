import java.io.IOException;
import java.io.InputStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

	static long result = 0;
	static long r;
	static long l;

	public static void main(String[] args) {
		int n = nextInt();
		Point[] point = new Point[n];
		for (int i = 0; i < n; ++i) {
			point[i] = new Point(nextInt(), nextInt());
		}

		List<E> es = new ArrayList<E>();
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; i < n; ++i) {
				E e = new E();
				e.f = i;
				e.l = j;
				e.value = ((long) (point[i].x) - point[j].x)
						* ((long) (point[i].x) - point[j].x)
						+ ((long) (point[i].y) - point[j].y)
						* ((long) (point[i].y) - point[j].y);
			}
		}

		int count[] = new int[n];
		long result = 0;
		int size = 0;
		long curValue = Long.MIN_VALUE;
		for (int i = 0; i < size; ++i) {
			E e = es.get(i);
			if (es.get(i).value != curValue) {
				curValue = es.get(i).value;
			}
			//if(es)
		}

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

	private static char nextChar() {
		return (char) (read());
	}

	private static long nextLong() {
		return Long.parseLong(nextString());
	}

}

class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class E implements Comparable<E> {
	public int f;
	public int l;
	public long value;

	@Override
	public int compareTo(E arg0) {
		return value > arg0.value ? 1 : (value < arg0.value ? -1 : 0);
	}

}
