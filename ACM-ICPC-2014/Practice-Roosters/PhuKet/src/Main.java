import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) {
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
	public void solve(InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int[] dp;
		Event event;
		while (n-- > 0) {
			List<Event> events = new ArrayList<Event>();
			dp = new int[11];
			for (int i = 0;; ++i) {
				event = new Event();
				event.s = in.nextInt();
				event.f = in.nextInt();
				if (event.s == 0 && event.f == 0)
					break;
				events.add(event);
			}

			Collections.sort(events);
			for (Event e : events) {
				for (int j = e.f; j < 11; ++j) {
					dp[j] = Math.max(dp[j], dp[e.s] + 1);
				}
			}
			long res = 0;
			for (int i = 0; i < 11; ++i) {
				res = Math.max(dp[i], res);
			}
			out.println(res);
		}
	}
}

class Event implements Comparable<Event> {
	int s;
	int f;

	@Override
	public int compareTo(Event other) {
		if (this.s != other.s)
			return this.s - other.s;
		return this.f - other.f;
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