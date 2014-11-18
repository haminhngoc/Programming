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
	public void solve(InputReader in, PrintWriter out) {
		int t = in.nextInt();
		while (t-- > 0) {
			solve1(in);
		}
	}

	private void solve1(InputReader in) {
		int n = in.nextInt();
		int x = in.nextInt();

		long temp = 0;
		long[] sums = new long[n + 1];

		for (int i = 1; i <= n; ++i) {
			sums[i] = sums[i - 1] + in.nextInt();
		}
		T[] sortedSum = new T[n+1];
		sortedSum[0] = new T(0, 0);
		for (int i = 1; i <= n; ++i) {
			sortedSum[i] = new T(i, sums[i]);
		}

		Arrays.sort(sortedSum, new Comparator<T>() {
			@Override
			public int compare(T a, T b) {
				if (a.v < b.v) {
					return -1;
				} else if (a.v > b.v) {
					return 1;
				}
				return a.p - b.p;
			}
		});

		int r = -1;

		for (int i = 1; i <= n; ++i) {
			int p = lowerBound(sortedSum, sums[i] - x, i);
			if (p == -1 || p == n) {
				continue;
			}

			if (r == -1) {
				r = i - sortedSum[p].p;
			} else {
				Math.min(r, i - sortedSum[p].p);
			}
		}

		System.out.println(r);

	}

	static int lowerBound(T[] sortedSum, long value, int p) {

		// for(int i )

		int l = 0;
		int r = sortedSum.length - 1;

		while (l < r) {
			int mid = (l + r+1) >> 1;

			if (sortedSum[mid].v > value) {
				r = mid - 1;
			}

			else if (sortedSum[mid].v == value && sortedSum[mid].p >= p) {
				r = mid - 1;
			} else {
				l = mid;
			}
		}

		if (sortedSum[l].v > value) {
			return - 1;
		}

		else if (sortedSum[l].v <= value && sortedSum[l].p >= p) {
			return - 1;
		}
		return l;
	}
}

class T implements Comparable<T> {
	int p;
	long v;

	public T(int p, long t) {
		this.p = p;
		this.v = t;
	}

	@Override
	public int compareTo(T o) {
		if (v < o.v) {
			return -1;
		}

		if (v > o.v) {
			return 1;
		}

		return p - o.p;
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