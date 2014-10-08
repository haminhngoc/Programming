import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public void main(String[] args) throws IOException {
		Init(System.in);

		long n = nextLong();
		long l = nextLong();
		long r = nextLong();

		long a[] = new long[(int) n];

		for (int i = 0; i < n; ++i) {
			a[i] = nextLong();
		}

		List<Long> list = new ArrayList<Long>();

		long t[] = new long[(int) n];
		t[0] = a[0];
		list.add(t[0]);
		for (int i = 1; i < n; ++i) {
			t[i] = t[i - 1] + a[i];
		}

		Collections.sort(list);

		for (int i = 0; i < n; ++i) {
			
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
