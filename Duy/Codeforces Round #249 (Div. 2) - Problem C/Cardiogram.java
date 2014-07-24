import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cardiogram {

	public static void main(String[] args) throws IOException {
		Cardiogram main = new Cardiogram();
		main.solve();
	}

	void solve() throws IOException {
		ReaderCardiogram reader = new ReaderCardiogram();
		reader.Init(System.in);
		int n = reader.NextInt();
		int[] inputs = new int[n];
		int max = 0;
		int min = 0;
		int ai = 0;
		int sum = 0;
		int temp1 = 0;
		int temp2 = 0;
		int maxHorizontal = 0;
		int maxVertical = 0;
		
		for (int i = 0; i < n; i++) {
			ai = reader.NextInt();
			inputs[i] = ai;
			maxHorizontal += ai;
			if (i % 2 == 0) {
				sum += ai;
				if (sum > max) {
					max = sum;
				}
			}
			if (i % 2 == 1) {
				sum -= ai;
				if (sum < min) {
					min = sum;
				}
			}
		}

		maxVertical = max - min;
		char[][] cardiogram = new char[maxVertical][maxHorizontal];
		for (int i = 0; i < maxVertical; i++) {
			for (int j = 0; j < maxHorizontal; j++) {
				cardiogram[i][j] = ' ';
			}
		}

		int start = min < 0 ? min * -1 : min;
		int h = 0;
		int v = start;
		for (int i = 0; i < n; i++) {

			for (int j = 0; j < inputs[i]; j++) {
				if (i % 2 == 0) {
					cardiogram[v][h] = '/';
					if (j != inputs[i] - 1)
						v++;
				} else {
					cardiogram[v][h] = '\\';
					if (j != inputs[i] - 1)
						v--;
				}
				h++;

			}

		}
		String testTimeOut = new String();
		for (int i = maxVertical - 1; i >= 0; i--) {
			for (int j = 0; j < maxHorizontal; j++) {
				//System.out.print(cardiogram[i][j]);
				testTimeOut+=cardiogram[i][j];
			}
			System.out.print(testTimeOut+ "\n");
			testTimeOut="";
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