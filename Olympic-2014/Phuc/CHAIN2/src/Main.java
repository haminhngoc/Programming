import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		int n = nextInt();
		String[] str = new String[n];

		for (int i = 0; i < n; ++i) {
			str[i] = nextString();
		}

		Arrays.sort(str);
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		int count[] = new int[n];
		int max = 1;
		for (int i = 0; i < n; ++i) {
			int l = str[i].length();
			StringBuilder temp = new StringBuilder();
			for (int j = 0; j < l - 1; ++j) {
				temp.append(str[i].charAt(j));
				int t = Arrays.binarySearch(str, temp.toString());
				if (t >= 0) {
					count[i] = Math.max(count[i], count[t] + 1);
				}
			}
			if (count[i] == 0) {
				count[i] = 1;
			}
			max = Math.max(max, count[i]);
		}
		
		System.out.println(max);

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
