import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		int k = nextInt();
		long sum[] = new long[n + 1];
		int z = (int) (1e9 + 7);
		for (int i = 0; i < n; ++i) {
			long t = nextLong();

			sum[i + 1] = sum[i] + t;
		}

		if (sum[n] == 0) {
			long count = 0;
			for (int i = 1; i <= n; ++i) {
				if (sum[i] == 0) {
					count++;
				}
			}

			long re = exe(count, k);

			System.out.println(re % z);
			return;
		}
		if (sum[n] % k != 0) {
			System.out.println(0);
			return;
		}

		long t = sum[n] / k;
		long arr[] = new long[k + 1];
		arr[0] = 1;
		for (int i = 1; i <= n; ++i) {
			if (sum[i] % t != 0 || sum[i] == 0) {
				continue;
			}
			long temp = sum[i] / t;
	
			arr[(int) temp] += arr[(int) (temp - 1)];
		}

		System.out.println(arr[k - 1]);

	}

	private static long exe(long count, int k) {

		long re = 1;
		long min = Math.min(k, count - k);
		long max = Math.max(k, count - k);
		List<Integer> list = find(min);
		long arr[] = new long[list.size()];
		long size = list.size();
		for (int i = (int) (max + 1); i <= count; ++i) {
			int j = 0;
			long z = i;
			while (z != 1) {
				if (j >= size) {
					break;
				}
				if (z % list.get(j) == 0) {
					arr[j]++;
					z /= list.get(j);
				} else {
					j++;
				}
			}
			re *= z;
			re %= 1e9 + 7;
		}
		for (int i = 2; i <= min; ++i) {
			int j = 0;
			int z = i;
			while (z != 1) {
				if (j >= size) {
					break;
				}
				if (z % list.get(j) == 0) {
					arr[j]--;
					z /= list.get(j);
				} else {
					j++;
				}
			}
		}

		for (int i = 0; i < size; ++i) {
			re *= pow(list.get(i), arr[i]);
			re %= 1e9 + 7;
		}

		return re;
	}

	private static long pow(long n, Long k) {
		long result = 0;
		if (k == 0) {
			return 1;
		}
		if (k == 1) {
			return n;
		}
		result = pow(n, k / 2);
		result *= result;
		result %= 1e9 + 7;
		if (k % 2 == 1) {
			result *= n;
			result %= 1e9 + 7;
		}
		return result;
	}

	private static List<Integer> find(long n) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i <= n; ++i) {
			if (check(i)) {
				list.add(i);
			}
		}
		return list;
	}

	private static boolean check(long n) {
		int end = (int) Math.sqrt(n);
		for (int i = 2; i <= end; ++i) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
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
