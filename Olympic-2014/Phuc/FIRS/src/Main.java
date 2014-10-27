import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class Main {

	public static void main(String[] args) {
		int n = nextInt();
		boolean died[] = new boolean[n + 2];

		T[] trees = new T[n];
		for (int i = 0; i < n; ++i) {
			trees[i] = new T(nextInt(), i + 1);
		}

		long count = 0;
		T tempTree;
		Arrays.sort(trees);
		for (int i = 0; i < n; ++i) {
			tempTree = trees[i];

			if (died[tempTree.pos]) {
				continue;
			}
			count++;
			died[tempTree.pos] = true;
			died[tempTree.pos - 1] = true;
			died[tempTree.pos + 1] = true;
		}

		System.out.println(count);

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

class T implements Comparable<T> {
	int height;
	int pos;

	public T(int h, int p) {
		this.height = h;
		this.pos = p;
	}

	@Override
	public int compareTo(T t) {
		if (height == t.height) {
			return pos - t.pos;
		}
		return height - t.height;
	}
}
