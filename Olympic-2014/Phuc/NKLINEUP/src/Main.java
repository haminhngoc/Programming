import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		

		int n = nextInt();
		int q = nextInt();
		int a[] = new int[n];

		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
		}
		SegmentTree tree = new SegmentTree(a);
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < q; ++i) {
			int z = nextInt();
			int b = nextInt();
			str.append(tree.get(z-1, b-1));
			str.append("\n");
		}

		System.out.println(str);
	}

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
	int[] max;
	int[] min;
	int[] data;

	int maxVal = -1;
	int minVal = Integer.MAX_VALUE;

	public SegmentTree(int[] data) {
		this.data = data;
		max = new int[4 * data.length + 20];
		min = new int[4 * data.length + 20];

		buildTree(0, 0, data.length - 1);
	}

	private void buildTree(int root, int left, int right) {
		if (left == right) {
			max[root] = min[root] = data[left];
			return;
		}
		int mid = (left + right) >> 1;
		buildTree(left(root), left, mid);
		buildTree(right(root), mid + 1, right);

		max[root] = Math.max(max[left(root)], max[right(root)]);
		min[root] = Math.min(min[left(root)], min[right(root)]);

	}

	public long get(int left, int right) {
		maxVal = -1;
		minVal = Integer.MAX_VALUE;
		get(0, 0, data.length-1, left, right);
		return maxVal - minVal;
	}

	private void get(int root, int leftRange, int rightRange, int left,
			int right) {
		if (left > rightRange || right < leftRange) {
			return;
		}

		if (left <= leftRange && right >= rightRange) {
			maxVal = Math.max(max[root], maxVal);
			minVal = Math.min(min[root], minVal);
		} else {
			int mid = (leftRange + rightRange) >> 1;
			get(left(root), leftRange, mid, left, right);
			get(right(root), mid + 1, rightRange, left, right);
		}

	}

	static int left(int root) {
		return (root << 1) + 1;
	}

	static int right(int root) {
		return (root << 1) + 2;
	}

}