import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {

		int n = nextInt();
		int q = nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
		}
		SegmentTree st = new SegmentTree(a);
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < q; i++) {
			int from = nextInt();
			int to = nextInt();
			st.get(from - 1, to - 1);
			res.append(st.maxVal - st.minVal);
			if (i < q - 1)
				res.append("\n");
		}
		System.out.println(res);
	}

	/************************************************************************************/
	static InputStream is = System.in;
	static private byte[] buffer = new byte[1024];
	static private int lenbuf = 0, ptrbuf = 0;

	static private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(buffer);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return buffer[ptrbuf++];
	}

	static private boolean isSpace(int c) {
		return !(c >= 33 && c <= 126);
	}

	static private int read() {
		int b;
		while ((b = readByte()) != -1 && isSpace(b))
			;
		return b;
	}

	static private double nextDouble() {
		return Double.parseDouble(nextString());
	}

	static private char nextChar() {
		return (char) read();
	}

	static private String nextString() {
		int b = read();
		StringBuilder sb = new StringBuilder();
		while (!(isSpace(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static private char[] nextString(int n) {
		char[] buf = new char[n];
		int b = read(), p = 0;
		while (p < n && !(isSpace(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static private int nextInt() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static private long nextLong() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static private int[] nextAi(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	static private Integer[] nextAi1(int n) {
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}
}

class SegmentTree {
	private int[] max;
	private int[] min;
	private int[] data;
	private int size = 0;
	public int maxVal = -1;
	public int minVal = Integer.MAX_VALUE;

	public SegmentTree(int[] in) {
		size = in.length;
		this.data = in;
		max = new int[4 * size + 10];
		min = new int[4 * size + 10];
		buildTree(0, 0, size - 1);
	}

	private void buildTree(int root, int lr, int rr) {
		if (lr == rr) {
			max[root] = min[root] = data[lr];
		} else {
			int mid = (lr + rr) >> 1;
			buildTree(left(root), lr, mid);
			buildTree(right(root), mid + 1, rr);

			max[root] = Math.max(max[left(root)], max[right(root)]);
			min[root] = Math.min(min[left(root)], min[right(root)]);
		}
	}

	public void get(int left, int right) {
		maxVal = -1;
		minVal = Integer.MAX_VALUE;
		get(0, 0, size - 1, left, right);
	}

	private void get(int root, int lr, int rr, int left, int right) {
		if (left > rr || right < lr)
			return;
		if (left <= lr && right >= rr) {
			maxVal = Math.max(max[root], maxVal);
			minVal = Math.min(min[root], minVal);
		} else {
			int mid = (lr + rr) >> 1;
			get(left(root), lr, mid, left, right);
			get(right(root), mid + 1, rr, left, right);
		}
	}

	static int left(int root) {
		return (root << 1) + 1;
	}

	static int right(int root) {
		return (root << 1) + 2;
	}

}

class InputReader {
	static BufferedReader reader;
	static StringTokenizer token;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		token = null;
	}

	static String next() {
		if (token == null || !token.hasMoreTokens()) {
			try {
				token = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return token.nextToken();
	}

	static int nextInt() {
		return Integer.parseInt(next());
	}
}

