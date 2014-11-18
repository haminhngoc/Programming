import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Stack;

class BINTREE {
	public static void main(String[] args) {
		solve();
	}

	static int[] pos = new int[50001];

	static void solve() {
		int n = nextInt();
		int[] preOrder = nextAi(n);
		int[] inOrder = nextAi(n);

		preLength = preOrder.length;
		inLength = inOrder.length;

		int inStart = 0;
		int inEnd = preLength - 1;

		for (int i = 0; i < inLength; i++) {
			pos[inOrder[i]] = i;
		}

		Node root = buildTree(preOrder, inOrder, inStart, inEnd);
		postOrder(root);
		System.out.println(res);
	}

	static StringBuilder res = new StringBuilder();

	private static void postOrder(Node root) {
		if (root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		res.append((root.val + " "));
	}

	static int preIndex = 0;
	static int preLength;
	static int inLength;

	static Node buildTree(int[] preOrder, int[] inOrder, int inStart, int inEnd) {

		if (inStart > inEnd) {
			return null;
		}

		Node root = new Node(preOrder[preIndex++]);

		if (inStart == inEnd) {
			return root;
		}
		int inIndex = pos[root.val];// searchIndex(inOrder, root.val, inStart,
									// inEnd);
		root.left = buildTree(preOrder, inOrder, inStart, inIndex - 1);
		root.right = buildTree(preOrder, inOrder, inIndex + 1, inEnd);

		return root;
	}

	static int searchIndex(int[] inOrder, int val, int start, int end) {
		int inIndex = 0;
		for (int cur = start; cur <= end; ++cur) {
			if (inOrder[cur] == val) {
				inIndex = cur;
				return inIndex;
			}
		}
		return -1;
	}

	/*****************************************************************
	 ******************** BASIC READER *******************************
	 *****************************************************************/

	static InputStream is = System.in;
	static private byte[] inbuf = new byte[1024];
	static private int lenbuf = 0, ptrbuf = 0;

	static private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	static private boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	static private int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	static private double nextDouble() {
		return Double.parseDouble(nextString());
	}

	static private char nextChar() {
		return (char) skip();
	}

	static private String nextString() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static private char[] nextString(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static private int[][] nextMatrix(int n, int m) {
		int[][] map = new int[n][];
		for (int i = 0; i < n; i++)
			map[i] = nextAi(n);
		return map;
	}

	static private int[] nextAi(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	static private Integer[] nextAI(int n) {
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
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
}

class Node {
	int val;
	Node left;
	Node right;

	public Node(int val) {
		this.val = val;
	}
}

