import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class KuriyamaMiraiStones {

	public static void main(String[] args) throws IOException {
		ReaderKuriyamaMiraiStones reader = new ReaderKuriyamaMiraiStones();
		reader.Init(System.in);
		int n = reader.nextInt();
		List<Long> list = new ArrayList<Long>();
		long[] sumUnSorted = new long[n + 1];
		long[] sumSorted = new long[n + 1];
		long temp;
		for (int i = 1; i <= n; ++i) {
			temp = reader.nextLong();
			list.add(temp);
			sumUnSorted[i] = sumUnSorted[i - 1] + temp;
		}
		Collections.sort(list, new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				if (o1 == o2)
					return 0;
				if (o1 < o2)
					return -1;
				return 1;
			}
		});
		for (int i = 1; i <= n; ++i) {
			sumSorted[i] = sumSorted[i - 1] + list.get(i-1);
		}

		int m = reader.nextInt();
		int type;
		int l, r;
		for (int i = 0; i < m; i++) {
			type = reader.nextInt();
			l = reader.nextInt();
			r = reader.nextInt();
			System.out.println(type == 2 ? sumSorted[r] - sumSorted[l - 1]
					: sumUnSorted[r] - sumUnSorted[l - 1]);
		}

	}
}

class ReaderKuriyamaMiraiStones {
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