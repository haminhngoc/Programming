import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;

public class SerejaandSwaps {

	public static void main(String[] args) throws IOException {

		ReaderSerejaandSwaps reader = new ReaderSerejaandSwaps();
		reader.Init(System.in);
		int n = reader.nextInt();
		int k = reader.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = reader.nextInt();
		}
		long max = Long.MIN_VALUE;
		long temp;
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> listTemp = new ArrayList<Integer>();
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 < o2) {
					return -1;
				}
				return o1 == o2 ? 0 : 1;
			}
		};

		/*
		 * int tempLength; int lisLegnth; for (int i = 0; i < n; ++i) { for (int
		 * j = 0; j < n; ++j) { temp = 0; for (int h = 0; h < n; ++h) { if (h <
		 * i || h > i + j) { list.add(a[h]); } else { listTemp.add(a[h]); temp
		 * += a[h]; } } Collections.sort(list, new Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer o1, Integer o2) { return
		 * Integer.compare(o1, o2); } }); Collections.sort(listTemp, new
		 * Comparator<Integer>() {
		 * 
		 * @Override public int compare(Integer o1, Integer o2) { return
		 * Integer.compare(o1, o2); } });
		 * 
		 * lisLegnth = list.size(); tempLength = listTemp.size(); int h = 0; int
		 * m = 0; int t = lisLegnth - 1; while (h < k && t >= 0 && m <
		 * tempLength && listTemp.get(m) < list.get(t)) { temp += list.get(t) -
		 * listTemp.get(m); h++; m++; t--; } if (temp > max) { max = temp; }
		 * 
		 * list.clear(); listTemp.clear(); } }
		 * 
		 * System.out.println(max); }
		 */
		Items[] arr = new Items[n];
		Items tempItems;
		for (int i = 0; i < n; ++i) {
			arr[i] = new Items();
			arr[i].a = a[i];
			arr[i].b = i;
		}
		Arrays.sort(arr, new Comparator<Items>() {
			@Override
			public int compare(Items o1, Items o2) {
				return Integer.compare(o1.a, o2.a);
			}
		});
		int max1 = Integer.MIN_VALUE;
		for (int left = 0; left < n; ++left) {
			long sum = 0;
			for (int right = left; right < n; ++right) {
				int[] x = Arrays.copyOfRange(a, left, right+1);
				Arrays.sort(x);
				sum+=a[right];
				int index = 0;
				int count = 0;
				int i = n - 1;
				int len = x.length;
				long tempSum = sum;
				while (i >= 0 && index < len && count < k
						&& arr[i].a > x[index]) {
					if (arr[i].b < left || arr[i].b > right) {
						tempSum += arr[i].a - x[index];
						count++;
						index++;
					}
					i--;
				}
				if (tempSum > max1) {
					max1 = (int) tempSum;
				}
			}
		}
		System.out.println(max1);
	}

	static class Items {
		int a;
		int b;
	}
}

class ReaderSerejaandSwaps {
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