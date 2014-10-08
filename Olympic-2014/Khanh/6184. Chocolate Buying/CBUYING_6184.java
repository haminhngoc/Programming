import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class CBUYING_6184 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream inputStream = System.in;
		InputReader in = new InputReader(inputStream);
		// Scanner scan = new Scanner(System.in);
		Integer N = in.nextInt();
		long B = in.nextLong();
		P[] A = new P[N];
		for (int i = 0; i < N; ++i) {
			A[i] = new P();
			A[i].price = in.nextLong();
			A[i].quantity = in.nextLong();
		}

		Arrays.sort(A);

		long count = 0;
		for (int i = 0; i < N; i++) {
			long plus = Check(B, A[i].price, A[i].quantity);
			count += plus;
			B -= (plus * A[i].price);
			if (plus < A[i].quantity)
				i = N;
		}
		System.out.println(count);
	}

	private static long Check(long b, long l, long m) {
		// TODO Auto-generated method stub
		long max = m * l;
		if (max > b)
			return b / l;
		else
			return m;
	}

}

class P implements Comparable<P> {
	public long quantity;
	public long price;

	public int compareTo(P arg0) {

		return (int) (this.price - arg0.price);
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

	public long nextLong() {
		return Long.parseLong(next());
	}
}
