import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DZYLovesModification {

	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(System.in);
		// BufferedReader in = new BufferedReader( new InputStreamReader(S));
		Reader8 in = new Reader8();
		in.Init(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		long k = in.nextLong();
		int p = in.nextInt();
		long[] row = new long[n];
		long[] col = new long[m];
		long temp = 0;
		long[] sR = new long[(int) (k + 1)];
		long[] sC = new long[(int) (k + 1)];
		PriorityQueue<Long> rq = new PriorityQueue<Long>();
		PriorityQueue<Long> cq = new PriorityQueue<Long>();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				temp = in.nextLong();
				row[i] += temp;
				col[j] += temp;
			}
			rq.add(-row[i]);
		}
		for (int j = 0; j < m; ++j) {
			cq.add(-col[j]);

		}
		long cR;
		long cC;
		for (int i = 1; i <= k; ++i) {
			cR = -rq.poll();
			cC = -cq.poll();
			sR[i] = cR + sR[i - 1];
			sC[i] = cC + sC[i - 1];
			cR -= p * m;
			cC -= p * n;
			rq.add(-cR);
			cq.add(-cC);
		}

		long pleasureLevel = Long.MIN_VALUE;

		for (int i = 0; k >= 0; ++i, k--) {
			pleasureLevel = Math.max(pleasureLevel, sR[i] + sC[(int) k] - p * k
					* i);

		}
		System.out.println(pleasureLevel);
	}
}

class Reader8 {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}