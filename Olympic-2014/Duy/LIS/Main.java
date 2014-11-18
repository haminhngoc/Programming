import java.util.*;
import java.io.*;

class LIS {
	public static void main(String[] args) throws IOException {
		Init(is);
		solve();
	}

	static void solve() throws IOException {
		int n = NextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = NextInt();
		}
		int[] prev = new int[n];
		int[] cur = new int[n];
		int size = 0;
		for (int i = 0; i < n; i++) {
			int pos = lowerBound(a, cur, size, a[i]);
			if (pos == size) {
				size++;
			}
			prev[pos] = pos > 0 ? cur[pos - 1] : -1;
			cur[pos] = i;
		}

		System.out.println(size);
	}

	private static int lowerBound(int[] a, int[] cur, int size, int key) {
		int left = -1;
		int right = size;
		while (right - left > 1) {
			int mid = (left + right) >> 1;
			if (a[cur[mid]] < key) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return right;
	}

	/******************************************************************
	 ****************************** READER*****************************
	 ******************************************************************/
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static InputStream is = System.in;

	static void Init(InputStream in) {
		reader = new BufferedReader(new InputStreamReader(in));
		tokenizer = new StringTokenizer("");
	}

	static String Next() throws IOException {

		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int NextInt() throws IOException {

		return Integer.parseInt(Next());
	}

	static long NextLong() throws IOException {

		return Long.parseLong(Next());
	}

	static Double NextDouble() throws IOException {

		return Double.parseDouble(Next());
	}
}

