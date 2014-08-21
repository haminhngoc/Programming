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
		long changeX[] = new long[sLength];
		long changeY[] = new long[sLength];
		for (int i = 0; i < sLength; ++i) {
			if (s[i] == 'R') {
				// xChange++;

				changeX[i] = 1 + (i > 0 ? changeX[i - 1] : 0);
				changeY[i] = (i == 0) ? 0 : changeY[i - 1];
			} else if (s[i] == 'L') {
				// xChange--;
				changeX[i] = -1 + (i > 0 ? changeX[i - 1] : 0);
				changeY[i] = (i == 0) ? 0 : changeY[i - 1];

			} else if (s[i] == 'U') {
				// yChange++;
				changeY[i] = 1 + (i > 0 ? changeY[i - 1] : 0);
				changeX[i] = (i == 0) ? 0 : changeX[i - 1];
			} else {
				// yChange--;
				changeY[i] = -1 + (i > 0 ? changeY[i - 1] : 0);
				changeX[i] = (i == 0) ? 0 : changeX[i - 1];
			}
		}

		for (int i = 0; i < sLength - 1; ++i) {
			if (check(a - changeX[i], b - changeY[i], changeX[sLength - 1],
					changeY[sLength - 1])) {
				System.out.println("Yes");
				return;
			}
		}
		if (check(a, b, changeX[sLength - 1], changeY[sLength - 1])) {
			System.out.println("Yes");
			return;
		}
		System.out.println("No");
	}

	static boolean check(long a, long b, long x, long y) {
		if (b * y < 0 || a * x < 0) {
			return false;
		}
		if (a == x && x == 0 && y != 0 && b % y == 0) {
			return true;
		}
		if (a == x && x == 0 && y != 0 && b % y != 0) {
			return false;
		}
		if (b == y && y == 0 && x != 0 && a % x == 0) {
			return true;
		}
		if (b == y && y == 0 && x != 0 && a % x != 0) {
			return false;
		}
		if (b == 0 && x == 0 && y == 0 && a == 0) {
			return true;
		}
		if ((x == 0 && a != 0) || (y == 0 && b != 0)
				|| (a == x && x == 0 && y == 0 && b != 0)
				|| (a != 0 && x == 0 && b == y && y == 0)) {
			return false;
		}
		if ((a % x != 0) || (b % y != 0) || (a / x != b / y)) {
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
