import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class A2 {

	public static void main(String[] args) {

		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader3 in = new InputReader3(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskD solver = new TaskD();
		solver.solve(in, out);
		out.close();
	}
}

class TaskD {

	public void solve(InputReader3 in, PrintWriter out) {
		int n = in.nextInt();
		int temp;
		int cnt = 0;
		int max = 0;

		for (int i = 0; i < n-1; ++i) {
			temp = in.nextInt();
			if (temp < 0) {
				max = Math.max(max, cnt);
				cnt = 0;
			} else {
				cnt++;
			}
		}
		temp = in.nextInt();
		if (temp < 0) {
			max = Math.max(max, cnt);
		} else {
			cnt++;
			max = Math.max(max, cnt);
		}
		out.println(max);
	}
}

class InputReader3 {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader3(InputStream stream) {
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