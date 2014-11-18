import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(in, out);
		out.close();
	}
}

class TaskA {

	public void solve(InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int k = in.nextInt();
		boolean mod[][] = new boolean[n + 1][k];
		mod[0][0] = true;
		for (int i = 1; i <= n; ++i) {
			long a = in.nextLong();
			for (int j = 0; j < k; ++j) {
				if (mod[i - 1][j]) {
					long t = (j + a) % k;
					t += t < 0 ? k : 0;

					mod[i][(int) t] = true;
					
					t = (j - a) % k;
					t += t < 0 ? k : 0;
					mod[i][(int) t] = true;
				}
			}
				
		}

		if (mod[n][0]) {
			System.out.println("Divisible");
		} else {
			System.out.println("Not divisible");
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
