import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FourPointPolyline {

	public static void main(String[] args) throws IOException {
		Init(System.in);
		int n = nextInt();
		int m = nextInt();
		if (n == 0) {
			System.out.println("0 1\n0 " + m + "\n0 0\n0 " + (m - 1));
			return;
		} else if (m == 0) {
			System.out.println("1 0\n" + n + " 0\n0 0\n" + (n - 1) + " 0");
			return;
		}
		double max;
		double temp = Math.sqrt(n * n + m * m);
		String result;
		if (n >= m) {
			if (m == 1) {
				System.out
						.println("0 0\n" + n + " " + 1 + "\n0 1\n" + n + " 0");
				return;
			}

			double t1 = 2 * Math.sqrt(n * n + (m - 1) * (m - 1));
			double t2 = n + temp;
			if (t1 > t2) {
				System.out.println("0 1\n" + n + " " + m + "\n0 0\n" + n + " "
						+ (m - 1));
			} else {
				System.out.println("0 0\n" + n + " " + m + "\n0 " + m + "\n"
						+ n + " 0");
			}
		} else {
			if (n == 1) {
				System.out
						.println("0 0\n1 "  + m + "\n1 0\n0 "+ m);
				return;
			}
			double t1 = 2 * Math.sqrt((n - 1) * (n - 1) + m * m);
			double t2 = m + temp;
			if (t1 > t2) {
				System.out.println("1 0\n" + n + " " + m + "\n0 0\n" + (n - 1)
						+ " " + m);
			} else {
				System.out.println("0 0\n" + n + " " + m + "\n" + n + " 0\n0 "
						+ m);
			}
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

	static Double NextDouble() throws IOException {
		return Double.parseDouble(next());
	}
}
