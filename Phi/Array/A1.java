import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class A1 {

	public static void main(String[] args) {

		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader2 in = new InputReader2(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskC solver = new TaskC();
		solver.solve(in, out);
		out.close();
	}
}

class TaskC {

	public void solve(InputReader2 in, PrintWriter out) {
		int n = in.nextInt();
		int last = in.nextInt();
		int temp;
		int cnt = 1;
		int max = 0;

		for (int i = 1; i < n - 1; ++i) {
			temp = in.nextInt();
			if (temp < last) {
				max = Math.max(max, cnt);
				cnt = 0;
			}
			cnt++;
			last = temp;
		}
		temp = in.nextInt();
		if (temp < last) {
			max = Math.max(max, cnt);
		} else {
			cnt++;
			max = Math.max(max, cnt);
		}
		out.println(max);
	}
}

class InputReader2 {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader2(InputStream stream) {
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