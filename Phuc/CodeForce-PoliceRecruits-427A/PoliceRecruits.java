import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PoliceRecruits {

	public static void main(String[] args) throws IOException {

		ReaderPoliceRecruits reader = new ReaderPoliceRecruits();
		reader.Init(System.in);
		int n = reader.nextInt();
		int countPolice = 0;
		int countCrime;
		int result = 0;
		int temp = 0;
		for (int i = 0; i < n; ++i) {
			temp = reader.nextInt();
			if (temp == -1) {
				if (countPolice <= 0) {
					result++;
				} else
					countPolice--;
			} else
				countPolice+=temp;
		}
		System.out.println(result);
	}

}

class ReaderPoliceRecruits {
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