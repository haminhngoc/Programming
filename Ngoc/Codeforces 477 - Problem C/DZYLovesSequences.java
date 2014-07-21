import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class DZYLovesSequences {
	public static void main(String[] args) throws IOException {
		ReaderSequences.Init(System.in);
		int n = ReaderSequences.nextInt(); // 100K
		long[] a = new long[n]; // 1B

		for (int i = 0; i < n; i++) {
			a[i] = ReaderSequences.nextInt();
		}

		int start = 0, end = 0;
		int preStart = -1, preEnd = -1;
		int max = Math.min(2, n);

		start = end = 0;
		while (end < n) {
			if (end < n - 1 && a[end] < a[end + 1]) {
				end++;
				continue;
			}

			if ((preStart >= 0 && preStart < preEnd 
					&& a[start] > a[preEnd - 1] + 1)
				|| (preStart >= 0 && start < end 
					&& a[preEnd] < a[start + 1] - 1)) {
				max = Math.max(max, end - preStart + 1);
			} else {
				max = Math.max(max, Math.min(end - start + 1 + 1, n));
			}

			preStart = start;
			preEnd = end;
			start = end = end + 1;
		}

		System.out.println(max);
	}
}

class ReaderSequences {
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

	static int nextInt() throws IOException {
		return Integer.parseInt(Next());
	}

	static long NextLong() throws IOException {
		return Long.parseLong(Next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(Next());
	}
}
