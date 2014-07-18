import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MultiplicationTable {
	static int n;
	static int[] a;

	public static void main(String[] args) throws IOException {
		initReader();
		while (true) {
			readInput();

			int result = solve(0, n, 0);

			System.out.println(result);

			break;
		}

	}

	public static int solve(int start, int length, int base) {
		int min = Integer.MAX_VALUE;
		for (int i = start; i < start + length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		int localResult = min - base;
		int previousMin = start;
		for (int i = start; i <= start + length; i++) {
			if (previousMin < start + length && a[previousMin] == min) {
				previousMin++;
				continue;
			}
			if (i == start + length || a[i] == min) {
				if (previousMin < i) {
					localResult += solve(previousMin, i - previousMin, min);
					previousMin = i;
				}
			}
		}
		return Math.min(length, localResult);
	}

	public static void readInput() throws IOException {
		n = nextInt();
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = nextInt();
		}
	}

	static BufferedReader reader;
	static StringTokenizer tokenizer;

	public static void initReader() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		tokenizer = new StringTokenizer("");
	}

	static String next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static String nextLine() throws IOException {
		return reader.readLine();
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static Double nextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
