import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1 {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		int a[] = new int[n];
		if (n == 0) {
			System.out.println(0);
			return;
		}
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
		}

		int max = 0;
		int start = 0;
		int lastEnd = -1;
		int maxStart = 0;
		for (int i = 1; i < n; ++i) {
			if (a[i] < a[i - 1]) {
				if (i - start > max) {
					max = i - start;
					maxStart = start;
				}
				start = i;
			}
		}
		if (n  - start > max) {
			max = n  - start;
			maxStart = start;
		}
		
		System.out.println(maxStart +" "+max);
	}

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
