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

class Main1 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader1 in = new InputReader1(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task1 solver = new Task1();
		solver.solve(in, out);
		out.close();
	}
}

class Task1 {
	static int n;
	static long arr[];

	public void solve(InputReader1 in, PrintWriter out) {
		n = in.nextInt();
		long f[] = new long[n];
		long v[] = new long[n];
		for (int i = 0; i < n; ++i) {
			f[i] = in.nextLong();
			v[i] = in.nextLong();
		}

		int t = in.nextInt();
		for (int i = 1; i <= t; ++i) {
			long maxF = in.nextLong();
			long time = in.nextLong();
			for (int j = 0; j < n; ++j) {
				f[j] *= time;
			}
			long r = s(f, v, maxF, time);
			if (r != Long.MAX_VALUE) {
				out.println("Case " + i + ": " + r);
			} else {
				out.println("Case " + i + ": IMPOSSIBLE");
			}
			for (int j = 0; j < n; ++j) {
				f[j] /= time;
			}
		}

	}

	private long s(long[] f, long[] v, long maxF, long time) {
		int index = 0;
		long result = Long.MAX_VALUE;
		long max = (1 << n) - 1;
		for (int i = 1; i <= max; ++i) {
			index = 0;
			int temp = i;
			long tempR = 0;
			long sumF = 0;
			while (temp > 0) {
				int z = temp % 2;
				if (z == 1) {
					tempR += v[index];
					sumF += f[index];
				}
				index++;
				temp = temp / 2;
			}
			if (sumF >= maxF && tempR < result) {
				result = tempR;
			}
		}
		return result;
	}
}

class InputReader1 {
	BufferedReader reader;
	StringTokenizer tokenizer;

	InputReader1(InputStream stream) {
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