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
		char[] c = new char[n];
		for (int i = 0; i < n; ++i) {
			c[i] = in.next().toCharArray()[0];
		}
		StringBuilder res = new StringBuilder();
		int i = 0;
		int j = c.length - 1;
		if (n == 1) {
			out.print(c[0]);
			return;
		}
		while (i <= j) {
			if (i == j) {
				res.append(c[i]);
				break;
			} 
			if (c[i] < c[j]) {
				res.append(c[i]);
				i++;
			} else if (c[i] > c[j]) {
				res.append(c[j]);
				j--;
			} else {
				int ii = i + 1;
				int jj = j - 1;
				while (ii < jj && c[ii] == c[jj]) {
					ii++;
					jj--;
				}
				if (c[ii] > c[jj]) {
					res.append(c[j]);
					j--;
				} else {
					res.append(c[i]);
					i++;
				}
			}
		}

		char[] tmp = res.toString().toCharArray();
		out.print(tmp[0]);
		for (int k = 1; k < tmp.length; k++) {
			if (k % 80 == 0) {
				out.println();
			}
			out.print(tmp[k]);
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