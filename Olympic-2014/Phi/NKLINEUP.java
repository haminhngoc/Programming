import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

class Main {

	public static void main(String[] args) {

		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		NKLINEUP solver = new NKLINEUP();
		solver.solve(in, out);
		out.close();
	}
}

class NKLINEUP {
	public void solve(InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int q = in.nextInt();
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = in.nextInt();
		}
		SegmentTree tree = new SegmentTree(n);
		tree.Init(a, 1, n, 1);
		int l, r;
		for (int i = 0; i < q; i++) {
			tree.qmin = Integer.MAX_VALUE;
			tree.qmax = Integer.MIN_VALUE;
			l = in.nextInt();
			r = in.nextInt();
			tree.query(1, l, r, 1, n);
			out.println(tree.qmax - tree.qmin);
		}
	}
}

class SegmentTree {
	public int[] treemax;
	public int[] treemin;

	int qmax;
	int qmin;

	SegmentTree(int n) {
		treemax = new int[4 * n + 1];
		treemin = new int[4 * n + 1];
	}

	public void Init(int[] arr, int l, int r, int cur) {
		if (l == r) {
			treemax[cur] = treemin[cur] = arr[l];
		} else {
			int mid = (l + r) / 2;
			Init(arr, l, mid, cur * 2);
			Init(arr, mid + 1, r, cur * 2 + 1);
			treemax[cur] = Math.max(treemax[cur * 2], treemax[cur * 2 + 1]);
			treemin[cur] = Math.min(treemin[cur * 2], treemin[cur * 2 + 1]);
		}
	}

	public void query(int cur, int i, int j, int l, int r) {
		if(l > j ||  r < i) return;
		if (i <= l && r <= j) {
			qmax = Math.max(qmax, treemax[cur]);
			qmin = Math.min(qmin, treemin[cur]);
		} else {
			int mid = (l + r) / 2;
			query(cur * 2, i, j, l, mid);
			query(cur * 2 + 1, i, j, mid + 1, r);
		}
	}
}

class Task {
	public void solve(InputReader in, PrintWriter out) {
		String longest = "";
		String s = in.next();
		while (!s.equals("E-N-D")) {
			s = s.replaceAll("[^A-Za-z/-]", "");
			if (s.length() > longest.length()) {
				longest = s;
			}
			s = in.next();
		}
		out.println(longest.toLowerCase());
	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}
}

