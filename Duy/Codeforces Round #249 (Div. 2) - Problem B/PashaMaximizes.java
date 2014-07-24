import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PashaMaximizes {

	public static void main(String[] args) throws IOException {
		PashaMaximizes main = new PashaMaximizes();
		main.solve();
	}

	void solve() throws IOException {
		ReaderPashaMaximizes reader = new ReaderPashaMaximizes();
		reader.Init(System.in);
		char[] a = reader.Next().toCharArray();
		int k = reader.NextInt();
		int lengthOfa = a.length;
		int length;
		boolean checkIncrease;
		char temp;
		int pos = 0;
		int lastPos = 0;
		int i = 0;
		int c = 0;
		while (k > 0) {
			length = k < lengthOfa && i + k < lengthOfa ? i + k : lengthOfa-1;
			pos = MaxPosition(i, length, a);
			temp = a[pos];
			if (temp > a[i]) {
				for (int ii = pos; ii > i && k > 0; ii--) {
					a[ii] = a[ii - 1];
					k--;
					lastPos = ii;
				}
				a[lastPos - 1] = temp;
			}
			checkIncrease = k < lengthOfa ? true : false;
			if (checkIncrease && c < lengthOfa - length) {
				c++;
			}
			if (i < lengthOfa - 1) {
				i++;
			} else {
				break;
			}
		}

		for (int j = 0; j < a.length; j++) {
			System.out.print(a[j]);
		}

	}

	int MaxPosition(int i, int j, char[] a) {
		int max = Integer.MIN_VALUE;
		int pos = 0;
		for (; i <= j; i++) {
			if (a[i] > max) {
				max = a[i];
				pos = i;
			}
		}
		return pos;
	}
}

class ReaderPashaMaximizes {
	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static String Next() throws IOException {
		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int NextInt() throws IOException {
		return Integer.parseInt(Next());
	}

	static long NextLong() throws IOException {
		return Long.parseLong(Next());
	}

	static Double NextDouble() throws IOException {
		return Double.parseDouble(Next());
	}
}