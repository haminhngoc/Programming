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
		int[] a = new int[7];
		while (true) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				a[i] = in.nextInt();
				sum += a[i];
			}
			if (sum == 0) {
				return;
			}
			int[] m = new int[4];
			int res = 0;
			res += a[0] / 20;
			a[0] %= 20;
			if (a[0] != 0) {
				a[1] = 20 - a[0] > a[1] ? 0 : a[1] + a[0] - 20;
				res++;
			}
			res += a[1] / 20;
			a[1] %= 20;
			if (a[1] != 0) {
				a[2] = 20 - a[1] >= a[2] ? 0 : a[2] + a[1] - 20;
				res++;
			}
			m[0] = a[2];
			m[1] = a[3];
			m[2] = a[4];
			res += a[6] / 30;
			a[6] %= 30;
			if (a[6] != 0) {
				a[5] = 30 - a[6] > a[5] ? 0 : a[6] + a[5] - 30;
				res++;
			}
			res += a[5] / 30;
			a[5] %= 30;
			m[3] = a[5];

			if (m[0] != 0) {
				res += m[0] / 20;
				m[0] %= 20;
				if (m[0] != 0) {
					m[1] = 20 - m[1] > m[0] ? 0 : m[1] + m[0] - 20;
					res++;
				}
			}
			res += m[1] / 25;
			m[1] %= 25;
			if (m[1] != 0) {
				m[2] = 25 - m[1] > m[2] ? 0 : m[2] + m[1] - 25;
				res++;
			}
			res += m[2] / 25;

			m[2] %= 25;

			if (m[2] + m[3] != 0) {
				if (m[2] + m[3] <= 25 || (m[2] == 0)) {
					res++;
				} else {
					res += 2;
				}
			}

			System.out.println(res);
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