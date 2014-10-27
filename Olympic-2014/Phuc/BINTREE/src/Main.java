import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Main {

	public static int tree[];
	public static int pre[];
	public static int inOrder[];
	public static int posIn[];
	public static StringBuilder stringBuilder = new StringBuilder();
	static int index = 0;

	public static void main(String[] args) {
		int n = nextInt();
		pre = new int[n + 500];
		inOrder = new int[n + 500];
		posIn = new int[n + 500];

		for (int i = 0; i < n; ++i) {
			pre[i] = nextInt();
		}
		for (int i = 0; i < n; ++i) {
			inOrder[i] = nextInt();
			posIn[inOrder[i]] = i;
		}
		tree = new int[4 * n + 20];
		index = 0;
		build(0, 0, n - 1);
		pos(0);
		System.out.println(stringBuilder);
	}

	private static void build(int node, int i, int j) {
		if (i > j) {
			return;
		}

		tree[node] = pre[index];
		index++;
		if (i == j) {
			return;
		}
		int mid = posIn[tree[node]];
		build(node * 2 + 1, i, mid - 1);
		build(node * 2 + 2, mid + 1, j);

	}

	private static void pos(int index) {
		if (tree[index] == 0) {
			return;
		}
		pos(2 * index + 1);
		pos(2 * index + 2);
		if (stringBuilder.length() != 0) {
			stringBuilder.append(" ");
			
		}
		stringBuilder.append(tree[index]);

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
