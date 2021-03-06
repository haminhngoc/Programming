import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javax.print.attribute.standard.Finishings;

public class Main {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		List<Integer> list = new ArrayList<Integer>();
		long R = 0;
		int a[] = new int[n];
		int count[] = new int[100000];
		int t[] = new int[131072];
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();

			R += i - find(t, a[i]);
			add(t, a[i]);

			count[a[i]]++;
		}

		System.out.println(R);

	}

	private static void add(int[] t, int value) {

		int r = value + 65535;
		while (r > 0) {
			t[r]++;
			r /= 2;
		}
	}

	private static int find(int[] t, int value) {

		int r = value + 65535;

		if (value >= 65536) {
			return t[1];
		}

		List<Integer> list = new ArrayList<Integer>();

		while (r > 0) {
			list.add(r);
			r /= 2;
		}
		int re = 0;
		int size = list.size();
		int index = 1;
		for (int i = size - 2; i >= 0; --i) {
			if (list.get(i) == list.get(i + 1) * 2 + 1) {
				re += t[list.get(i + 1) * 2];
			}

			if (i == 0) {
				re += t[list.get(i)];
			}
		}
		return re;
	}

	public static int lower(List<Integer> list, int v) {
		int size = list.size();
		if (v <= list.get(0)) {
			return 0;
		}

		int left = 0;
		int right = size - 1;
		while (left < right) {
			int mid = (left + right + 1) / 2;
			if (list.get(mid) >= v) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		if (list.get(left) < v) {
			return left + 1;
		} else {
			return left;
		}
	}

	public static int upper(List<Integer> list, int v) {
		int size = list.size();
		if (v >= list.get(size - 1)) {
			return 0;
		}

		int left = 0;
		int right = size - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (list.get(mid) <= v) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		if (list.get(left) > v) {
			return size - left;
		} else {
			return size - left - 1;
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
