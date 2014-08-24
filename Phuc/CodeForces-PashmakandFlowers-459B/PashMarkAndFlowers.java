import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PashMarkAndFlowers {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		long countMin = 0;
		long countMax = 0;
		//int temp = nextInt();
		int temp;
		for (int i = 0; i < n; ++i) {
			temp = nextInt();
			if (temp > max) {
				max = temp;
				countMax = 1;
			} else if (temp == max) {
				countMax++;
			}

			if (temp < min) {
				min = temp;
				countMin = 1;
			} else if (temp == min) {
				countMin++;
			}
		}
		if (max == min) {
			System.out.println(0 + " " + countMax * (countMax - 1) / 2);
		} else {
			System.out.println((max - min) + " " + countMax * countMin);
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
