import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {

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

	public void solve(InputReader in, PrintWriter out) throws IOException {
		int p = in.nextInt();
		for (int i = 0; i < p; i++) {
			StringBuilder res = new StringBuilder();
			int id = in.nextInt();
			char[] patern = in.nextLine().toCharArray();
			int n = in.nextInt();
			int cur = 0;
			for (int j = 0; j < n; j++) {
				int tmp = in.nextInt();
				cur += tmp;
				if (cur >= patern.length) {
					cur -= patern.length;
				}
				if (cur < 0) {
					cur = patern.length + cur;
				}
				res.append(patern[cur]);
			}
			System.out.println(id + " " + res);
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

	public String nextLine() throws IOException {
		return reader.readLine();
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
