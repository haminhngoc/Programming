import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cardiogram {

	public static void main(String[] args) throws IOException {
		ReaderCardiogram reader = new ReaderCardiogram();
		reader.Init(System.in);
		int n = reader.nextInt();
		long[] x = new long[n + 1];
		long[] y = new long[n + 1];
		x[0] = 0;
		y[0] = 0;
		long maxY = 0;
		long minY = 0;
		long temp = 0;
		for (int i = 1; i <= n; ++i) {
			temp = reader.nextLong();
			x[i] = temp + x[i - 1];
			y[i] += y[i - 1] + temp * (i % 2 == 0 ? -1 : 1);
			if (y[i] > maxY) {
				maxY = y[i];
			}

			if (y[i] < minY) {
				minY = y[i];
			}
		}
		long maxX = x[n];
		int index = 0;
		String tempString;
		for (long i = maxY; i > minY; --i) {
			index = 0;
			tempString = "";
			for (int j = 0; j < maxX; ++j) {
				if (x[index] == j) {
					if (y[index] > y[index + 1] && y[index] == i) {
						tempString += "\\";
					} else if (y[index] < y[index + 1] && y[index] + 1 == i) {
						tempString += "/";
					} else
						tempString += " ";
				} else if (x[index + 1] - 1 == j && index < n) {
					if (y[index] > y[index + 1] && y[index + 1] + 1 == i) {
						tempString += "\\";
					} else if (y[index] < y[index + 1] && y[index + 1] == i) {
						tempString += "/";
					} else
						tempString += " ";
				} else if (index < n) {
					if (y[index] < y[index + 1]
							&& i - y[index] - 1 == j - x[index]) {
						tempString += "/";
					} else if (y[index] > y[index + 1]
							&& i - y[index] == -j + x[index]) {
						tempString += "\\";
					} else
						tempString += " ";
				}
				if (index < n && x[index + 1] - 1 == j) {
					index++;
				}
			}
			System.out.println(tempString);
		}

	}
}

class ReaderCardiogram {
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