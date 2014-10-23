import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStream;

class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(1, in, out);
		out.close();
	}
}

class Task {

	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int d = in.nextInt();
		Integer[] trees = new Integer[n];
		int[] hights = new int[n];
		for (int i = 0; i < n; ++i) {
			trees[i] = in.nextInt();
		}
		Arrays.sort(trees);
		for (int i = 1; i < n; ++i) {
			hights[i] = trees[i] - trees[0];
			if (hights[i] % d != 0) {
				System.out.println(-1);
				return;
			}
		}
		long res = 0;
		for (int i = 1; i < n; i++) {
			res += hights[i] / d;
		}
		System.out.println(res);
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

}
