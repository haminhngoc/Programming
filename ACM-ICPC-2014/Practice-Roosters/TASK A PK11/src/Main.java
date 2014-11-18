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
	static int n;

	public void solve(InputReader in, PrintWriter out) {
		n = in.nextInt();
		long[] rate = new long[n];
		long[] cost = new long[n];
		for (int i = 0; i < n; i++) {
			rate[i] = in.nextLong();
			cost[i] = in.nextLong();
		}
		long m = in.nextInt();
		for (int id = 1; id <= m; id++) {
			long v = in.nextLong();
			long t = in.nextLong();
			long[] tRate = Arrays.copyOf(rate, rate.length);
			for (int i = 0; i < n; i++) {
				tRate[i] *= t;
			}
			long res = getAns(tRate, cost, v);
			if (res == Long.MAX_VALUE) {
				out.printf("Case %d: IMPOSSIBLE\n", id);
				continue;
			}
			out.println("Case " + id + ": " + res);
		}
	}

	private long getAns(long[] tRate, long[] cost, long v) {
		long max = 1L << n;
		long res = Long.MAX_VALUE;

		for (int i = 1; i < max; i++) {
			long[] a = get(i);
			long val = 0;
			long tmp = 0;
			for (int j = 0; j < n; j++) {
				if (a[j] != 0) {
					val += tRate[j];
					tmp += cost[j];
				}
			}
			if (val >= v) {
				res = Math.min(res, tmp);
			}
		}
		return res;
	}

	private long[] get(long i) {
		long[] res = new long[n];
		int index = 0;
		while (i / 2 != 0) {
			res[index++] = i % 2;
			i /= 2;
		}
		if (i % 2 != 0) {
			res[index++] = i % 2;
		}
		return res;
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