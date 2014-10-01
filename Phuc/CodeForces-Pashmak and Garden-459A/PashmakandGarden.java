import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PashmakandGarden {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int x1 = nextInt();
		int y1 = nextInt();
		int x2 = nextInt();
		int y2 = nextInt();
		if (x1 == x2) {
			System.out.println((x1 + (y2 - y1)) + " " + y1 + " "
					+ (x1 + (y2 - y1) + " " + y2));
		} else if (y2 == y1) {
			System.out.println(x1 + " " + (y1 + (x2 - x1)) + " " + x2 + " "
					+ (y2 + (x2 - x1)));
		} else if (Math.abs(x2 - x1) == Math.abs(y2 - y1)) {
			System.out.println(x1 + " " + y2 + " " + x2 + " " + y1);
		} else {
			System.out.println(-1);
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
