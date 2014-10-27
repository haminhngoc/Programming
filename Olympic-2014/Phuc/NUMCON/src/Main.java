import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		PriorityQueue<Q> list = new PriorityQueue<Q>();

		do {
			Q q = new Q();
			q.s = nextString();
			list.add(q);
		} while (hasNext());
		StringBuilder str = new StringBuilder();
		int size = list.size();
		for (int i = 0; i < size; ++i) {
			str.append(list.poll().s);
		}
		System.out.println(str);
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

class Q implements Comparable<Q> {
	public String s;

	@Override
	public int compareTo(Q q) {

		if (s.length() == q.s.length()) {
			return q.s.compareTo(s);
		}

		int sL = s.length();
		int qL = q.s.length();

		int min = Math.min(sL, qL);
		for (int i = 0; i < min; ++i) {
			if (s.charAt(i) > q.s.charAt(i)) {
				return -1;
			} else if (s.charAt(i) < q.s.charAt(i)) {
				return 1;
			}

		}
		if (sL == min) {
			for (int i = min; i < qL; ++i) {
				if (q.s.charAt(i) > q.s.charAt(i - min)) {
					return 1;
				} else if (q.s.charAt(i) < q.s.charAt(i - min)) {
					return -1;
				}
			}
			return 0;
		} else {
			for (int i = min; i < sL; ++i) {
				if (s.charAt(i) > s.charAt(i - min)) {
					return -1;
				} else if (s.charAt(i) < s.charAt(i - min)) {
					return 1;
				}
			}
			return 0;
		}
	}

}