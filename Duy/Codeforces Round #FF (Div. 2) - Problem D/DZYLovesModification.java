import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class DZYLovesModification {

	public static void main(String[] args) throws IOException {
		DZYLovesModification main = new DZYLovesModification();
		main.solve();

	}

	void solve() throws IOException {
		Reader8 reader = new Reader8();
		reader.Init(System.in);
		int n = Reader8.NextInt();
		int m = Reader8.NextInt();
		int k = Reader8.NextInt();
		int p = Reader8.NextInt();
		long[] rows = new long[n];
		long[] columns = new long[m];
		PriorityQueue rowsHeap = new PriorityQueue();
		PriorityQueue columnsHeap = new PriorityQueue();
		long temp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp = reader.NextInt();
				temp /= -1;
				rows[i] += temp;
				columns[j] += temp;
			}
		}
		for (int i = 0; i < n; i++) {
			rowsHeap.add(rows[i]);
		}
		for (int i = 0; i < m; i++) {
			columnsHeap.add(columns[i]);
		}
		long result = Long.MAX_VALUE;
		long r = 0;
		long c = 0;
		long temp1 = 0;
		long sumRow = 0;
		long sumCol = 0;
		long[] rowVal = new long[k+1];
		long[] colVal = new long[k+1];
		rowVal[0] = 0;
		colVal[0] = 0;
		for (int i = 1; i <= k; i++) {
			r = (long) rowsHeap.poll();
			temp1 = r + (p * m);
			sumRow += r;
			rowVal[i] = sumRow;
			rowsHeap.offer(temp1);
			
			c = (long) columnsHeap.poll();
			temp1 = c + (p * n);
			sumCol += c;
			colVal[i] = sumCol;
			columnsHeap.offer(temp1);
		}
		long tempRes = 0;
		for (int i = 0; i <= k; i++) {
			tempRes = rowVal[i] + colVal[k - i] + (long)i * (k - i) * p;
			if (tempRes < result) {
				result = tempRes;
			}
		}

		System.out.print(result * -1);
	}

}

class Reader8 {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String Next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int NextInt() throws IOException {
		return Integer.parseInt(Next());
	}

	static long NextLong() throws IOException {
		return Long.parseLong(Next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(Next());
	}
}