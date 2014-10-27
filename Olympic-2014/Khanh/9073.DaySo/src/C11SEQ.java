import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class C11SEQ {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int N = in.nextInt();
		int L = in.nextInt();
		int R = in.nextInt();

		float[] arr = new float[N];
		for (int i = 0; i < N; ++i)
			arr[i] = in.nextFloat();
		

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

	public float nextFloat() {
		return Float.parseFloat(next());
	}
}