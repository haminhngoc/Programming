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
	static InputReader in;

	public void solve(InputReader in, PrintWriter out) throws IOException {
		String s = in.next();
		int l = s.length();
		int g = (l + 2) / 3;
		int maxL = g * 3 - l;
		for (int i = 0; i < maxL; ++i) {
			s = "0" + s;
		}

		char[] ss = s.toCharArray();
		for (int i = 0; i < ss.length;) {
			int t = 0;
			t+= (ss[i++] - '0') << 2;
			t+= (ss[i++] - '0') << 1;
			t+= (ss[i++] - '0');
			System.out.print(t);
		}
		System.out.println();
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