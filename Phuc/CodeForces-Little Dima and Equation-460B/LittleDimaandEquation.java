import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LittleDimaandEquation {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int a = nextInt();
		int b = nextInt();
		int c = nextInt();

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		StringBuilder result = new StringBuilder();
		int count = 0;
		for (int i = 1; i <= 81; ++i) {
			long temp = (long) Math.pow(i, a) * b;
			long x = temp + c;

			if (x > 0 && x < 1000000000 && check(x, i)) {
				result.append(x + " ");
				count++;
			}

		}
		System.out.println(count);
		System.out.println(result);

	}

	static boolean check(long x, long i) {
		int sum = 0;
		while (x > 0) {
			sum += x % 10;
			x /= 10;
		}

		if (sum == i) {
			return true;

		} else {
			return false;
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
