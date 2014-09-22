import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CielAndFlowers {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int r = nextInt();
		int g = nextInt();
		int b = nextInt();
		int result = r / 3 + g / 3 + b / 3;

		int rm = r % 3;
		int gm = g % 3;
		int bm = b % 3;

		if (rm == 0 && gm == 2 && bm == 2 && r > 0) {
			result++;
		} else if (rm == 2 && gm == 0 && bm == 2 && g > 0) {
			result++;
		} else if (rm == 2 && gm == 2 && bm == 0 && b > 0) {
			result++;
		} else {
			result += Math.min(rm, Math.min(gm, bm));
		}
		System.out.println(result);
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
