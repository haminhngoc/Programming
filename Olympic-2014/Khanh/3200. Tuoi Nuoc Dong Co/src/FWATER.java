import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class FWATER {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int N = in.nextInt();
		int[] arrWP = new int[N];// Well's Price
		for (int i = 0; i < N; ++i)
			arrWP[i] = in.nextInt();
		int[] arrSW = new int[N];// sum Wire's price
		for (int i = 0; i < N; ++i) {
			arrSW[i] = 0;
			for (int j = 0; j < N; ++j)
				arrSW[i] += in.nextInt();
		}
		int min1 = arrWP[0];
		int min2 = arrSW[0];
		for (int i = 0; i < N; ++i) {
			if (arrSW[i] < min2)
				min2 = arrSW[i];
			if (arrWP[i] < min1)
				min1 = arrWP[i];
		}
		System.out.println((min1 + min2));
	}

}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}
}