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
			sum[i + 1] = sum[i] + nextLong();
		}

		if (sum[n] == 0) {
			
			int count = 0;
			for (int i = 1; i <= n; ++i) {
				if (sum[i] == 0) {
					count++;
				}
			}

			if (count < k) {
				System.out.println(0);
				return;
			}
			if (k == 1) {
				System.out.println(1);
				return;
			}

		
			long re = exe(count - 1, k - 1);

			System.out.println(re);
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
			int temp = (int) (sum[i] / t);
			if (temp == k) {
				continue;
			}
			arr[temp] += arr[(temp - 1)];
			arr[temp] %= z;
		}

		System.out.println(arr[k - 1]);

	}

	private static long exe(int count, int k) {
		int con = 1000000007;
		long re = 1;
		int min = Math.min(k, count - k);
		int max = Math.max(k, count - k);
		List<Integer> list = generatePrimeList((int) Math.sqrt(count));
		int size = list.size();
		int arr[] = new int[count + 1];
		for (int i = 2; i <= count; ++i) {
			arr[i] = i;
		}
		for (int i = 0; i < size; ++i) {
			int temp = list.get(i);
			int end1 = min / temp;
			long c = 0;
			for (int j = 1; j <= end1; ++j) {
				int z = j * temp;
				while (arr[z] % temp == 0) {
					arr[z] /= temp;
					c--;
				}
			}
			int end2 = count / temp;

			for (int j = (max + temp) / temp; j <= end2; ++j) {
				int z = j * temp;
				while (arr[z] % temp == 0) {
					arr[z] /= temp;
					c++;
				}
			}

			re *= pow(temp, c);
			re %= con;
		}
		int temp[] = new int[min + 1];

		for (int i = 2; i <= min; ++i) {

			temp[arr[i]]--;

		}

		for (int i = max + 1; i <= count; ++i) {
			if (arr[i] <= 1) {
				continue;
			}
			if (arr[i] <= min) {
				temp[arr[i]]++;
			} else {
				re *= arr[i];
				re %= con;
			}
		}

		for (int i = 2; i <= min; ++i) {
			if (temp[i] == 0) {
				continue;
			}
			re *= pow(i, temp[i]);
			re %= con;
		}

		return re;
	}

	private static long pow(long n, long k) {
		long result = 0;
		if (k == 0) {
			return 1;
		}
		if (k == 1) {
			return n;
		}
		result = pow(n, k / 2);
		result = result * result;
		result %= 1e9 + 7;
		if (k % 2 == 1) {
			result *= n;
			result %= 1e9 + 7;
		}
		return result;
	}

	private static ArrayList<Integer> generatePrimeList(int limit) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(2);
		result.add(3);
		int resultSize = 2;
		int end;
		int j;
		for (int i = 5; i <= limit; i += 2) {
			end = (int) Math.sqrt(i);
			j = 0;
			while (j < resultSize && result.get(j) <= end) {
				if (i % result.get(j) == 0) {
					break;
				}
				j++;

			}
			if (j >= resultSize || result.get(j) > end) {
				result.add(i);
				resultSize++;
			}

		}
		return result;
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
