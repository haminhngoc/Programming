import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int c = nextInt();
		int n = nextInt();
		int arr[] = new int[n + 1];

		for (int i = 0; i < n; ++i) {
			arr[i] = nextInt();

		}

		 System.out.println(solve(arr, 0, 0, c));
		//System.out.println(solve1(arr, c));
	}

	private static int solve1(int[] arr, int c) {
		int length = arr.length;

		boolean temp[] = new boolean[c + 1];
		temp[0] = true;
		for (int i = 0; i < length; ++i) {
			for (int j = c; j >= arr[i]; --j) {
				if (temp[j - arr[i]]) {
					temp[j] = true;
				}
			}
		}
		for (int j = c; j >= 0; --j) {
			if (temp[j]) {
				return j;
			}
		}
		return 0;
	}

	private static int solve(int[] arr, int index, int currentWeight, int limit) {
		if (currentWeight == limit || index >= arr.length) {
			return currentWeight;
		}
		if (currentWeight + arr[index] <= limit) {
			int temp = solve(arr, index + 1, currentWeight + arr[index], limit);
			int t = solve(arr, index + 1, currentWeight, limit);
			return Math.max(temp, t);
		}
		return solve(arr, index + 1, currentWeight, limit);
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
