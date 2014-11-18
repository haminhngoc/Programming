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

		int count = 0;
		while (t-- > 0) {
			count += solve1(in);
		}
		
		System.out.println(count);
	}

	private int solve1(InputReader in) {
		double a = in.nextDouble();
		double b = in.nextDouble();
		double c = in.nextDouble();
		double w = in.nextDouble();

		if (w > 7) {
			System.out.println(0);
			return 0;
		}

		if (a + b + c <= 125) {
			System.out.println(1);
			return 1;
		}

		if (a <= 56 && b <= 45 && c <= 25) {
			System.out.println(1);
			return 1;
		}
		System.out.println(0);
		return 0;
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

	public double nextDouble() {
		return Double.parseDouble(next());
	}
}