import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		int k = nextInt();

		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < n; ++i) {
			long a = nextLong();
			long end = (long) Math.sqrt(a);
			for (int j = 1; j <= end; ++j) {
				if (a % j == 0) {
					list.add((long) j);

					if (a / j != j) {
						list.add(a / j);
					}
				}
			}
		}

		Collections.sort(list);

		long val = 1;
		long count = 0;
		long size = list.size();
		for (int i = (int) (size - 1); i >= 0; --i) {
			if (list.get(i) == val) {
				count++;
			} else {
				if (count >= k) {
					System.out.println(val);
					return;
				}
				val = list.get(i);
				count = 1;
			}
		}

		System.out.println(1);

	}

	static long gcd(long x, long y) {
		if (x % y == 0) {
			return y;
		}
		return gcd(y, x % y);
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
