import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class JzzhuAndChildren {

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
		int m, n, ith;
		n= in.nextInt();
		m = in.nextInt();
		int timesToGo = 1;
		int maxTimes = 1;
		int last = 1;
		
		for (int i = 1; i <= n; i++) {
			ith = in.nextInt();
			timesToGo = (ith / m) + (ith % m != 0 ? 1 : 0);
			if (timesToGo >= maxTimes)
			{
				maxTimes = timesToGo;
				last = i;
			}
		}
		out.println(last);
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

}