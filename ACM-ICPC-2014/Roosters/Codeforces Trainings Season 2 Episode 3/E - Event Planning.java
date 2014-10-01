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
		TaskE solver = new TaskE();
		solver.solve(in, out);
		out.close();
	}
}

class TaskE {

	public void solve(InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int budget = in.nextInt();
		int hotel = in.nextInt();
		int week = in.nextInt();
		
		int available;
		long mincost = Long.MAX_VALUE;
		int curcost;
		for(int i = 0; i < hotel; ++i){
			curcost = in.nextInt();
			for(int j = 0; j < week; ++j){
				available = in.nextInt();
				if(available >= n){
					mincost = Math.min(mincost, curcost*n);
				}
			}
		}
		if(mincost > budget){
			out.println("stay home");
			return;
		}
		out.println(mincost);
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