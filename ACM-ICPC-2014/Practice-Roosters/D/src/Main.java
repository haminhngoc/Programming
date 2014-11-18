import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
//// Not completed
class Main {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}
}

class Task {
	static StringBuilder str = new StringBuilder();
	static InputReader in;
	static int[] arr;
	static E[] edges;
	static int n;
	static int m;

	public void solve(InputReader in, PrintWriter out) {
		int t = in.nextInt();
		this.in = in;
		for (int i = 1; i <= 1; ++i) {
			str = new StringBuilder();
			int count = solve1();
		}
	}

	private int solve1() {
		n = in.nextInt();
		m = in.nextInt();
		arr = new int[n + 1];
		edges = new E[m];
		for (int i = 0; i < m; ++i) {
			edges[i] = new E(in.nextInt(), in.nextInt());
		}
		return 0;
	}

	int check0() {
		if (n % 6 != 0) {
			return -1;
		}
		arr = new int[n + 1];
		for (int i = 0; i < m; ++i) {
			arr[edges[i].a]++;
			arr[edges[i].b]++;
		}
		for (int i = 1; i <= n; ++i) {
			if (arr[i] != 2) {
				return -1;
			}
		}

		return n / 6 - 1;

	}

	int check1() {
		if (n % 2 == 0 || m != n - 1) {
			return -1;
		}
		arr = new int[n + 1];
		for (int i = 0; i < m; ++i) {
			arr[edges[i].a]++;
			arr[edges[i].b]++;
		}
		int c1 = 0;
		int c2 = 0;
		for (int i = 1; i <= n; ++i) {
			if (arr[i] == 1) {
				c1++;
			} else if (arr[i] == 2) {
				c2++;
			}
		}
		if (c1 != 2)
			return n / 6 - 1;
		return 0;
	}
}

class E {
	public int a;
	public int b;

	public E(int c, int d) {
		a = c;
		b = d;
	}
}

class InputReader {
	BufferedReader reader;
	StringTokenizer tokenizer;

	InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				e.printStackTrace();
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
}