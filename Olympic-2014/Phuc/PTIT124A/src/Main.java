import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		int t = nextInt();
		for (int i = 1; i <= t; ++i) {
			solve(i);
		}
	}

	private static void solve(int test) {
		int r = nextInt();
		int c = nextInt();
		char s[] = nextString2().toCharArray();
		int[][] matrix = new int[r][c];

		int[] str = new int[r * c];
		int index = 0;
		int end = r * c;
		for (int i = 0; i < s.length && index < end; ++i) {
			int temp = (s[i] == ' ' ? 0 : s[i] - 'A' + 1);
			str[index++] = (temp & 0x10) >> 4;
			str[index++] = ((temp & 0x08) >> 3);
			str[index++] = ((temp & 0x04) >> 2);
			str[index++] = ((temp & 0x02) >> 1);
			str[index++] = (temp & 0x01);
		}
		int t = 0;
		int d = r - 1;
		int l = 0;
		int right = c - 1;
		
		for (int j = 0; j < end;) {
			for (int i = l; i <= right && j < end; i++) {
				matrix[t][i] = str[j];
				j++;
			}
			for (int i = t + 1; i <= d && j < end; i++) {
				matrix[i][right] = str[j];
				j++;
			}

			for (int i = right - 1; i >= l && j < end; i--) {
				matrix[d][i] = str[j];
				j++;
			}

			for (int i = d - 1; i > t && j < end; i--) {
				matrix[i][l] = str[j];
				j++;
			}

			t++;
			d--;
			l++;
			right--;

		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(test + " ");
		for (int i = 0; i < r; ++i) {

			for (int j = 0; j < c; ++j) {

				stringBuilder.append(matrix[i][j]);
			}

		}

		System.out.println(stringBuilder);

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

	public static String nextString2() {
		StringBuilder str = new StringBuilder();

		int b= readByte();
		while (!isSpace(b) || b == ' ') {
			str.appendCodePoint(b);
			b = readByte();
		}

		return str.toString();
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
