import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CielAndRobot {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int a = nextInt();
		int b = nextInt();
		char s[] = next().toCharArray();
		int sLength = s.length;

		int xChange = 0;
		int yChange = 0;
		int changeX[] = new int[sLength];
		int changeY[] = new int[sLength];
		for (int i = 0; i < sLength; ++i) {
			if (s[i] == 'R') {
				// xChange++;

				changeX[i] = 1 + i > 0 ? changeX[i - 1] : 0;
			} else if (s[i] == 'L') {
				// xChange--;
				changeX[i] = -1 + i > 0 ? changeX[i - 1] : 0;

			} else if (s[i] == 'U') {
				// yChange++;
				changeY[i] = 1 + i > 0 ? changeY[i - 1] : 0;
			} else {
				// yChange--;
				changeY[i] = -1 + i > 0 ? changeY[i - 1] : 0;
			}
		}

		for (int i = 0; i < sLength; ++i) {

		}
	}

	boolean check(int a, int b, int x, int y) {
		if (a * x < 0 || b * y < 0 || (a != x && a * x == 0)
				|| (b != y && b * y == 0) || (a / x != b / y)) {
			return false;
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
