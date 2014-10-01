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

	public void solve(InputReader in, PrintWriter out) {
		int N = in.nextInt();
		while (N != 0) {
			solve1(in, out, N);
			N = in.nextInt();
		}
	}

	private void solve1(InputReader in, PrintWriter out, int n) {
		long sumHour = 0;
		long nightMinutes = 0;
		String t;
		Boolean check = true;
		for (int i = 0; i < n; ++i) {
			t = in.next();
			int h = Integer.parseInt(t.substring(0, 2));
			int m = Integer.parseInt(t.substring(3));
			int sR = h * 60 + m;
			t = in.next();
			h = Integer.parseInt(t.substring(0, 2));
			m = Integer.parseInt(t.substring(3));
			int sS = h * 60 + m;
			t = in.next();
			h = Integer.parseInt(t.substring(0, 2));
			m = Integer.parseInt(t.substring(3));
			int s = h * 60 + m;
			t = in.next();
			h = Integer.parseInt(t.substring(0, 2));
			m = Integer.parseInt(t.substring(3));
			int end = h * 60 + m;
			if (end - s > 2 * 60) {
				check = false;
			}
			sumHour += end - s;
			if (end > sS) {
				if ((end - sS) * 2 >= (end - s)) {
					nightMinutes += end - s;
				} else {
					nightMinutes += end - sS;
				}
			} else if (s < sR) {
				if ((sR - s) * 2 >= (end - s)) {
					nightMinutes += end - s;
				} else {
					nightMinutes += sR - s;
				}
			}
		}

		if (check && nightMinutes >= 10 * 60 && sumHour >= 50) {
			System.out.println("PASS");
		} else {
			System.out.println("NON");
		}

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