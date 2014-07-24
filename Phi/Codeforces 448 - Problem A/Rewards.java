import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class Rewards {

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
	private static long ans = 0;
	private static Long[] a = new Long[5000];

	public void solve(InputReader in, PrintWriter out) {
		int ith, sum, need;
		int n;
		need = 0;
		sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += in.nextInt();
		}
		need += (sum / 5) + (sum % 5 != 0 ? 1 : 0);
		sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += in.nextInt();
		}
		need += (sum / 10) + (sum % 10 != 0 ? 1 : 0);
		n = in.nextInt();
		if (need > n)
		{
			out.println("NO");
		}
		else
		{
			out.println("YES");
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