import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class PNUMBER {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		InputReader1783 in = new InputReader1783(inputStream);
		int A = in.nextInt();
		int B = in.nextInt();
		boolean arr[] = new boolean[B + 1];
		for (int i = 1; i < B + 1; i++)
			arr[i] = true;
		arr[1] = false;
		for (int i = 2; i < B + 1; i++)
			for (int j = 2 * i; j < B + 1; j += i)
				arr[j] = false;
		for (int i = A; i < B + 1; i++)
			if (arr[i] == true)
				System.out.println(i);
	}

}

class InputReader1783 {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader1783(InputStream stream) {
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