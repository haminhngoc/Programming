import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class C {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		long a[][] = new long[n][n];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				a[i][j] = nextLong();
			}
		}

		long x[] = new long[n];
		long y[] = new long[n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i + j >= n) {
					break;
				}
				x[i] += a[j][j + i];
			}
		}

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				if (i - j < 0) {
					break;
				}
				y[i] += a[j][i - j];
			}
		}

		List<V> l1 = new ArrayList<V>();
		List<V> l2 = new ArrayList<V>();
		V temp;
		for (int i = 0; i < n; ++i) {
			for (int j = i; j < n; j += 2) {
				temp = new V();
				temp.value = x[i] + y[j]
						- ((j - i) % 2 == 0 ? a[(j - i) / 2][(i + j) / 2] : 0);

				temp.x = i;
				temp.y = j;
				l1.add(temp);
			}
		}

		Collections.sort(l1, new Comparator<V>() {
			@Override
			public int compare(V o1, V o2) {

				return Long.compare(o2.value, o1.value);
			}
		});

		long size = l1.size();
		long result = 0;
		int count = 1;
		l2.add(l1.get(0));
		int p = (l1.get(0).y - l1.get(0).x) / 2;
		int q = (l1.get(0).y + l1.get(0).x) / 2;
		for (int i = 1; i < size; ++i) {
			int t1 = (l1.get(i).y - l1.get(i).x) / 2;
			int t2 = (l1.get(i).y + l1.get(i).x) / 2;
			if (Math.abs(t2 - q) == Math.abs(t1 - p)) {
				continue;
			}

			System.out.println((p + 1) + " " + (q + 1) + " " + (t1 + 1) + " "
					+ (t2 + 1));
			return;
		}
	}

	static class V {
		long value;
		int x;
		int y;
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
