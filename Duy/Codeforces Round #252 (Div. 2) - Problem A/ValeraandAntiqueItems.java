import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

public class ValeraandAntiqueItems {

	public static void main(String[] args) throws IOException {
		ValeraandAntiqueItems main = new ValeraandAntiqueItems();
		main.solve();
	}

	void solve() throws IOException {
		Reader1 reader = new Reader1();
		reader.Init(System.in);
		int nSeller = reader.NextInt();
		int numberOfItems = 0;
		long money = reader.NextLong();
		Vector prices = new Vector();
		long[] temp;
		for (int i = 0; i < nSeller; i++) {
			numberOfItems = reader.NextInt();
			temp = new long[numberOfItems];
			for (int j = 0; j < numberOfItems; j++) {
				temp[j] = reader.NextLong();
			}
			Arrays.sort(temp);
			if (temp[0] < money) {
				prices.addElement(i + 1);
			}
		}
		System.out.print(prices.size() + "\n");
		System.out.print(prices.toString().replaceAll("[\\[\\],]", ""));
	}

}

class Reader1 {
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