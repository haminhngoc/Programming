import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		// in = new FileInputStream("in.txt");
		int n = nextInt();
		List<T> s = new ArrayList<T>();

		int r = 0;
		int size = 0;
		for (int i = 0; i < n; ++i) {
			int t = nextInt();
			T temp = null;
			while (size > 0 && s.get(size - 1).v >= t) {
				size--;
				temp = s.remove(size);
				int min = Math.min(temp.v, i - temp.p);
				if (temp.v <= i - temp.p && temp.v > r) {
					r = temp.v;
				}
			}
			if (temp != null) {
				if (t <= i - temp.p + 1 && t > r) {
					r = t;
				}
				s.add(new T(temp.p, t));
				size++;
				continue;
			}
			s.add(new T(i, t));
			size++;

		}

		while (size > 0) {
			size--;
			T t = s.remove(size);
			if (t.v > r && t.v <= n - t.p) {
				r = t.v;
			}

		}

		System.out.println(r);

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

class T {
	public int p;
	public int v;

	public T(int p, int v) {
		this.p = p;
		this.v = v;
	}
}
