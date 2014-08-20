import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LittlePonyandSortbyShift {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		int a[] = new int[n];
		boolean check = true;
		int count = 0;
		int position = 0;
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
			if (i > 0 && a[i] < a[i - 1]) {
				count++;
				position = i;
			}
		}

		if (count > 1) {
			System.out.println(-1);
		} else if (count == 0) {
			System.out.println(0);
		} else {
			if (a[n - 1] > a[0]) {
				System.out.println(-1);
			} else {
				System.out.println(n - position);
			}

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
