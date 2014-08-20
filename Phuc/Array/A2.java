import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2 {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();

		int a[] = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
		}

		int startMax = -1;
		int max = 0;
		int tempStart = -1;
		for (int i = 0; i < n; ++i) {
			if (a[i] < 0 && tempStart >= 0) {
				if (i - tempStart > max) {
					max = i - tempStart;
					startMax = tempStart;
					
				}
				tempStart = -1;
			} else if (a[i] >= 0 && tempStart == -1) {
				tempStart = i;

			}
		}

		if (tempStart >= 0 && n - tempStart > max) {
			max = n - tempStart;
			startMax = tempStart;
		}
		if (startMax == -1) {
			System.out.println(-1);
		} else {
			System.out.println((startMax + " " + max));

		}
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
