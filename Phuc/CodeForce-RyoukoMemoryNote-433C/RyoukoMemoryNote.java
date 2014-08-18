import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class RyoukoMemoryNote {

	public static void main(String[] args) throws IOException {
		ReaderRyoukoMemoryNote reader = new ReaderRyoukoMemoryNote();
		reader.Init(System.in);
		int n = reader.nextInt();
		int m = reader.nextInt();
		if (n == 1) {
			System.out.println(0);
			return;
		}
		int[] pages = new int[m + 1];
		long min = 0;
		PriorityQueue<Long>[] less = new PriorityQueue[n + 1];
		PriorityQueue<Long>[] more = new PriorityQueue[n + 1];
		long[] lessCount = new long[n + 1];
		long[] moreCount = new long[n + 1];
		for (int i = 0; i <= n; ++i) {
			less[i] = new PriorityQueue<Long>();
			more[i] = new PriorityQueue<Long>();
		}
		long temp;
		for (int i = 1; i <= m; ++i) {
			pages[i] = reader.nextInt();
			if (i >= 2) {
				temp = pages[i] - pages[i - 1];
				if (temp > 0) {
					more[pages[i]].add(temp);
					moreCount[pages[i]]++;

					less[pages[i - 1]].add(temp);
					lessCount[pages[i - 1]]++;

				} else if (temp < 0) {
					temp = -temp;
					less[pages[i]].add(temp);
					lessCount[pages[i]]++;
					moreCount[pages[i - 1]]++;
					more[pages[i - 1]].add(temp);
				}

				min += Math.abs(temp);
			}

		}
		// min -= pages[1];

		long maxAdjust = 0;
		long lessSize = 0;
		long moreSize = 0;
		long tempAdjust = 0;
		long next;
		for (int i = 1; i <= n; ++i) {
			temp = 0;
			tempAdjust = 0;
			lessSize = lessCount[i];
			moreSize = moreCount[i];
			if (moreSize > lessSize) {
				while (moreSize > lessSize) {
					next = more[i].poll();

					tempAdjust += (long)(moreSize - lessSize) * (long)(next - temp);
					lessSize++;
					moreSize--;
					temp = next;
				}
			} else if (moreSize < lessSize) {
				while (moreSize < lessSize) {
					next = less[i].poll();

					tempAdjust += (long)(lessSize - moreSize) * (long)(next - temp);
					lessSize--;
					moreSize++;
					temp = next;
				}

			}
			if (tempAdjust > maxAdjust) {
				maxAdjust = tempAdjust;
			}
		}

		System.out.println(min - maxAdjust);

		// min -= pages[1];
		// long sum = min;
		// min = sum - Math.abs(pages[1] - pages[2]);
		//
		// long temp;
		// long temp1;
		// for (int i = 2; i < m; ++i) {
		// temp = sum - Math.abs(pages[i] - pages[i - 1])-Math.abs(pages[i] -
		// pages[i + 1])+Math.abs(pages[i-1] - pages[i + 1]);
		//
		//
		// min = min > temp ? temp : min;
		// }
		//
		// min = min > (sum - Math.abs(pages[m] - pages[m - 1])) ? (sum - Math
		// .abs(pages[m] - pages[m - 1])) : min;

		// System.out.println(min);
	}
}

class ReaderRyoukoMemoryNote {
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