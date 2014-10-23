import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BASEH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader2892 in = new InputReader2892(System.in);
		int k = in.nextInt();
		in.nextInt();
		String s = "";
		while (k > 1) {
			if (k % 2 == 0)
				s = 0 + s;
			else
				s = 1 + s;

			k = k / 2;
		}
		s = 1 + s;
		System.out.println(s);
	}
}

class InputReader2892 {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader2892(InputStream stream) {
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