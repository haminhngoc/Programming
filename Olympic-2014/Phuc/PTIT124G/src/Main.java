import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		int n = nextInt();
		int k = nextInt();

		int pre[] = new int[n + 2];
		int next[] = new int[n + 2];
		for (int i = 1; i <= n; ++i) {
			pre[i] = i - 1;
			next[i] = i + 1;
		}

		next[0] = 1;
		pre[n + 1] = n;
		
		for (int i = 0; i < k; ++i) {
			int t = nextInt();
			int q = nextInt();

			int z = next[t];
			int p = pre[t];

			pre[z] = p;
			next[p] = z;

			z = pre[q];
			next[z] = t;
			pre[t] = z;

			next[t] = q;
			pre[q] = t;
		}

		int i = 0;
		StringBuilder str = new StringBuilder();
		while (next[i] <= n) {
			if (str.length() > 0) {
				str.append(" ");
			}
			str.append(next[i]);
			i = next[i];
		}

		System.out.println(str);
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