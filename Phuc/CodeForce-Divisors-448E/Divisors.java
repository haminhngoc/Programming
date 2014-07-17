import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public class Divisors {

	static int maxLeft = 100000;
	static List<Long> primatives;
	static List<Long> resultProblem;
	public static void main(String[] args) throws IOException {
		ReaderDivisors reader = new ReaderDivisors();
		reader.Init(System.in);
		long X = reader.nextLong();
		double k = reader.NextDouble();
		if (k >= Math.pow(10, 5)) {
			if (X > 1) {
				double end = Math.pow(10, 5);
				for (int i = 0; i < end; ++i) {
					System.out.print(1 + " ");

				}
				return;
			} else {
				System.out.print(1);
				return;
			}
		}
		if (k == 0 || X == 1) {
			System.out.print(X);
			return;
		}

		int end = (int) Math.sqrt(X);
		primatives = generate(end);
		int length = primatives.size();
		int i;
		for (i = 0; i < length; ++i) {
			if (X % primatives.get(i) == 0) {
				break;
			}
		}
		if (i >= length) {
			for (i = 1; i <= k; ++i) {
				System.out.print(1 + " ");
			}
			if (k < 100000) {
				System.out.print(X);
			}
			return;
		}
		//Date start = new Date();
		resultProblem  = new ArrayList<Long>();
		dfs(X, 1, k);
		int resultsize = resultProblem.size();
		for( i = 0; i <resultsize; ++i){
			System.out.print(resultProblem.get(i)+" ");
		}
		//Date endTime = new Date();
		//System.out.println(-start.getTime() + endTime.getTime());
		System.out.println();
	}

	private static void dfs(long x, int i, double k) {
		if (x == 1) {
			//System.out.print(x + " ");
			resultProblem.add(x);
			maxLeft--;
			return;
		}
		if (Collections.binarySearch(primatives, x) >= 0) {
			for (int j = 0; j < (k - i + 1); ++j) {
				resultProblem.add((long) 1);
				maxLeft--;
				if (maxLeft <= 0)
					return;
			}
			resultProblem.add(x);
			maxLeft--;
			return;
		}
		List<Integer> divisor = new ArrayList<Integer>();
		int end = (int) Math.sqrt(x);
		for (int j = 1; j <= end; ++j) {
			if (x % j == 0) {
				if (i == k) {
					resultProblem.add((long) j);
					maxLeft--;
				}

				else {
					dfs(j, i + 1, k);

				}

				if (maxLeft > 0) {
					if (j != x / j)
						divisor.add(j);
				} else {
					return;
				}
			}
		}
		int divisorLength = divisor.size();
		for (int j = divisorLength - 1; j >= 0; j--) {
			if (i == k) {
				resultProblem.add(x / divisor.get(j));
				maxLeft--;
			}

			else {
				dfs(x / divisor.get(j), i + 1, k);

			}
			if (maxLeft <= 0) {
				return;
			}
		}
	}

	private static List<Long> generate(int limit) {
		List<Long> result = new ArrayList<Long>();
		result.add((long) 2);
		result.add((long) 3);
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
				result.add((long) i);
				resultSize++;
			}

		}
		return result;
	}

}

class ReaderDivisors {
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
