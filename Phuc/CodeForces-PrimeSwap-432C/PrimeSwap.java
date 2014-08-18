import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class PrimeSwap {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		int[] arr = new int[n + 1];
		int[] position = new int[n + 1];
		
		List<Integer> primes = generatePrimeList(n);
		int[] adjust = new int[n + 2];
		long primesSize = primes.size();
		int number1 = 0;
		int number2 = 0;
		for (int i = 0; i < primesSize; i++) {
			for (int j = 0; j < primesSize; j++) {
				number1 = primes.get(i);
				number2 = primes.get(j);
				if (number1 + number2 > n) {
					break;
				}
				adjust[number1 + number2] = number1;
			}
		}
		
		StringBuilder stmp = new StringBuilder();
		
		for (int i = 1; i <= n; ++i) {
			arr[i] = nextInt();
			position[arr[i]] = i;
		}
		int result = 0;
		List<Integer> first = new ArrayList<Integer>();
		List<Integer> second = new ArrayList<Integer>();
		int currentPosition;
		int temp;
		int t;
		int a, b, c;
		for (int i = 1; i <= n; i++) {
			if (arr[i] == i) {
				continue;
			}
			result++;
			currentPosition = position[i];
			temp = currentPosition - i + 1;
			if (Collections.binarySearch(primes, temp) >= 0) {
				//first.add(i);
				stmp.append(i+ " "+ currentPosition+"\n");
				//second.add(currentPosition);
				position[arr[i]] = currentPosition;
				t = arr[i];
				arr[i] = arr[currentPosition];
				arr[currentPosition] = t;
			} else if (temp % 2 == 1
					|| Collections.binarySearch(primes, temp -1) >= 0) {

				a = temp % 2 == 1 ? currentPosition - adjust[temp +1] + 1
						: currentPosition - 1;
				result++;
				//first.add(a);
				//first.add(i);
				//second.add(currentPosition);
				//second.add(a);
				stmp.append(a+ " "+ currentPosition+"\n");
				stmp.append(i+ " "+ a+"\n");
				position[arr[a]] = currentPosition;
				position[arr[i]] = a;
				arr[currentPosition] = arr[a];
				arr[a] = arr[i];

			} else {
				result += 2;
				a = currentPosition - 1;

				b = a - adjust[temp] + 1;
				/*first.add(a);
				first.add(b);
				first.add(i);*/
				stmp.append(a+ " "+ currentPosition+"\n");
				stmp.append(b+ " "+ a+"\n");
				stmp.append(i+ " "+ b+"\n");
				/*second.add(currentPosition);
				second.add(a);
				second.add(b);*/
				position[arr[a]] = currentPosition;
				position[arr[b]] = a;
				position[arr[i]] = b;
				arr[currentPosition] = arr[a];
				position[i] =i;
				arr[a] = arr[b];
				arr[b] = arr[i];
				arr[i] = i;
			}
		}
		System.out.println(result);
		/*for (int i = 0; i < result; ++i) {
			System.out.println(first.get(i) + " " + second.get(i));
		}*/
		System.out.print(stmp);

	}

	private static List<Integer> generatePrimeList(int limit) {
		List<Integer> result = new ArrayList<Integer>();
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

	// input
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
