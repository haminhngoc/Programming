import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

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
	Integer[] x;
	Integer[] y;
	int xx;
	int yy;
	long sumx;
	long sumy;
	int n;

	public void solve(InputReader in, PrintWriter out) {
		int ca =1;
		while ((n = in.nextInt()) != 0) {
			x = new Integer[n];
			y = new Integer[n];
			sumx = 0;
			sumy = 0;
			for (int i = 0; i < n; ++i) {
				x[i] = in.nextInt();
				y[i] = in.nextInt();
				sumx += x[i];
				sumy += y[i];
			}

			Arrays.sort(x);
			Arrays.sort(y);

			long total = calx() + caly();

			System.out.println("Case "+ca+": (" + xx + "," + yy + ") " + total);
			ca++;
		}
	}

	private long calx() {
		long min = sumx;
		xx = 0;
		long last = sumx;
		long temp;

		int index = 0;
		int limit = x[n - 1];
		for (int i = 1; i <= limit; ++i) {
			while (i > x[index]) {
				index++;
				if (index == n)
					break;
			}
			temp = last + (index) - (n - index);
			if (temp < min) {
				min = temp;
				xx = i;
			}
			last = temp;
		}
		return min;
	}

	private long caly() {
		long min = sumy;
		yy = 0;
		long last = sumy;
		long temp;

		int index = 0;
		int limit = y[n - 1];
		for (int i = 1; i <= limit; ++i) {
			while (i > y[index]) {
				index++;
				if (index == n)
					break;
			}
			temp = last + (index) - (n - index);
			if (temp < min) {
				min = temp;
				yy = i;
			}
			last = temp;
		}
		return min;
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