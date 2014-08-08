import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ShowerLine {

	private static long max = 0;
	private static int[][] g = new int[5][5]; // 10^5

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		InputReader reader = new InputReader(inputStream);
		int[] order = new int[] { 0, 1, 2, 3, 4 };
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++)
				g[i][j] = reader.nextInt();
		}
		Permute(order, 5, 0);
		System.out.println(max);
	}

	private static void Permute(int[] order, int n, int current) {
		for (int i = current; i < n; i++) {
			Swap(order, i, current);
			Permute(order, n, current+1);
			Swap(order, current, i);
		}
		if (current == n - 1) {
			long tmp = Sum(order);
			if (tmp > max)
				max = tmp;
		}
	}

	private static long Sum(int[] order) {
		long result = 0;
		int remain = 5;
		while (remain > 0) {
			for (int i = 5 - remain; i < 4; i += 2) {
				result += g[order[i]][order[i + 1]] + g[order[i + 1]][order[i]];
			}
			remain--;
		}
		return result;
	}

	private static void Swap(int[] array, int a, int b) {
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}

	private static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}

}
