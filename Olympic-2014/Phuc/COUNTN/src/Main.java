import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	public static void main(String[] args) throws FileNotFoundException {
		//in  = new FileInputStream("in.txt");
		StringBuilder str = new StringBuilder();
		while (hasNext()) {
			int n = nextInt();

			str.append(solve(n));
			str.append("\n");
		}
		System.out.print(str);
	}

	private static long solve(int n) {
		n = n << 1;
		n -= 2;
		int count = 0;
		int k = 2;
		while (n > 0) {
			k += 2;
			n -= k;
			if (n % k == 0) {
				count++;
			}
		}

		return count;

	}

	public static InputStream in = System.in;
	public static byte[] bytes = new byte[2048];
	public static int lenbuf = 0;
	public static int ptrbuf = 0;

	public static boolean hasNext() {
		if (ptrbuf == 0) {
			try {
				lenbuf = in.read(bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new InputMismatchException();
			}
		}
		if (lenbuf <= 0) {
			return false;
		}
		for (; ptrbuf < lenbuf; ++ptrbuf) {
			if (!isSpace(bytes[ptrbuf])) {
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
