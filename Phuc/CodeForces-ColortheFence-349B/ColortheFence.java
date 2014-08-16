import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ColortheFence {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int v = nextInt();
		Digit[] cost = new Digit[9];
		for (int i = 0; i < 9; ++i) {
			cost[i] = new Digit();
			cost[i].number = i + 1;
			cost[i].cost = nextInt();
		}
		Arrays.sort(cost, new Comparator<Digit>() {
			@Override
			public int compare(Digit o1, Digit o2) {
				if (o1.cost < o2.cost) {
					return -1;
				}
				if (o1.cost > o2.cost) {
					return 1;
				}
				return Integer.compare(o2.number, o1.number);
			}
		});

		if (v < cost[0].cost) {
			System.out.println(-1);
			return;
		}

		int minCost = cost[0].cost;
		if (v % minCost == 0) {
			StringBuilder temp = new StringBuilder();
			for (int i = 0; i < v / minCost; ++i) {
				temp.append(cost[0].number);
			}
			System.out.println(temp);
			return;
		}
		int count = v / minCost - 1;

		int left = v % minCost + minCost;

		int more = cost[0].number;
		int costMore = 0;
		for (int i = 1; i < 9; ++i) {
			if (cost[i].cost <= left && more < cost[i].number) {
				more = cost[i].number;
				costMore = cost[i].cost;
			}
		}
		if (more == cost[0].number) {
			StringBuilder temp = new StringBuilder();
			temp.append(more);

			for (int i = 0; i < count; ++i) {
				temp.append(cost[0].number);
			}
			System.out.println(temp);
			return;
		}

		left -= costMore;
		boolean canChange = left > 0 && count > 0;
		StringBuilder temp = new StringBuilder();
		temp.append(more);
		int i;

		while (canChange && count > 0) {
			more = cost[0].number;
			costMore = 0;
			for (i = 1; i < 9; ++i) {
				if (cost[i].cost - cost[0].cost <= left
						&& cost[i].number > more) {
					costMore = cost[i].cost;
					more = cost[i].number;
				}
			}
			if (more == cost[0].number) {
				break;
			}

			left -= costMore - cost[0].cost;
			temp.append(more);
			count--;

		}

		for (i = 0; i < count; ++i) {
			temp.append(cost[0].number);
		}
		System.out.println(temp);
	}

	static class Digit {
		int number;
		int cost;
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

	static long nextLong() throws IOException {
		return Long.parseLong(next());
	}

	static int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
}
