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
		TaskG solver = new TaskG();
		solver.solve(in, out);
		out.close();
	}
}

class TaskG {
	public void solve(InputReader in, PrintWriter out) {
		int n = in.nextInt();
		for (int m = 0; m < n; m++) {

			int w = in.nextInt();
			int a = in.nextInt();
			int b = in.nextInt();
			train[] na = new train[a];
			train[] nb = new train[b];
			for (int i = 0; i < a; i++) {
				String from = in.next();
				String to = in.next();
				train tmp = new train();
				tmp.f = parse(from);
				tmp.t = parse(to);
				na[i] = tmp;
			}

			for (int i = 0; i < b; i++) {
				String from = in.next();
				String to = in.next();
				train tmp = new train();
				tmp.f = parse(from);
				tmp.t = parse(to);
				nb[i] = tmp;
			}

			Arrays.sort(na, new Comparator<train>() {

				@Override
				public int compare(train t1, train t2) {
					return Integer.compare(t1.f, t2.f);
				}
			});
			Arrays.sort(nb, new Comparator<train>() {

				@Override
				public int compare(train t1, train t2) {
					return Integer.compare(t1.t, t2.t);
				}
			});

			int cntA = a;
			int cntB = b;
			int i = 0;
			int j = 0;
			while (i < na.length && j < nb.length) {
				if (na[i].f < nb[j].t + w) {
					i++;
				} else {
					cntA--;
					i++;
					j++;
				}
			}

			Arrays.sort(na, new Comparator<train>() {

				@Override
				public int compare(train t1, train t2) {
					return Integer.compare(t1.t, t2.t);
				}
			});
			Arrays.sort(nb, new Comparator<train>() {

				@Override
				public int compare(train t1, train t2) {
					return Integer.compare(t1.f, t2.f);
				}
			});

			i = 0;
			j = 0;
			while (j < nb.length && i < na.length) {
				if (na[i].t + w > nb[j].f) {
					j++;
				} else {
					cntB--;

					i++;
					j++;
				}
			}
			out.println(String.format("Case #%d: %d %d", m + 1, cntA, cntB));
		}
	}

	private int parse(String in) {
		int pos = in.indexOf(":");
		String hh = in.substring(0, pos);
		String mm = in.substring(pos + 1, in.length());
		int out = Integer.parseInt(hh) * 60 + Integer.parseInt(mm);
		return out;
	}
}

class train {
	int f;
	int t;
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