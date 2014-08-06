import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RyoukoMemoryNote {

	public static void main(String[] args) throws IOException {
		ReaderRyoukoMemoryNote reader = new ReaderRyoukoMemoryNote();
		reader.Init(System.in);
		int n = reader.nextInt();
		int m = reader.nextInt();
		if (n == 1) {
			System.out.println(0);
			return;
		}
		int[] pages = new int[m + 1];
		long min = 0;
		for (int i = 1; i <= m; ++i) {
			pages[i] = reader.nextInt();
			min += Math.abs(pages[i] - pages[i - 1]);
		}
		min -= pages[1];
		long sum = min;
		min = sum - Math.abs(pages[1] - pages[2]);

		long temp;
		long temp1;
		for (int i = 2; i < m; ++i) {
			temp = sum - Math.abs(pages[i] - pages[i - 1])-Math.abs(pages[i] - pages[i + 1])+Math.abs(pages[i-1] - pages[i + 1]);
		
			
			min = min > temp ? temp : min;
		}

		min = min > (sum - Math.abs(pages[m] - pages[m - 1])) ? (sum - Math
				.abs(pages[m] - pages[m - 1])) : min;
		System.out.println(min);
	}
}

class ReaderRyoukoMemoryNote {
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