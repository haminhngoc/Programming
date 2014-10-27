import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class C11BEAU {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int N = in.nextInt();
		for (int i = 0; i < N; ++i) {
			long cA = in.nextLong();
			long cB = in.nextLong();
			long mA = in.nextLong();
			long mB = in.nextLong();

			if (cA * cB * mA * mB == 0) {
				if ((cB == 0 && cA == 0) || (mA == 0 && mB == 0))
					System.out.println(0);
				else {
					if (cA == 0 || mA == 0)
						System.out.println(Math.min(mB, cB));
					else if (cB == 0 || mB == 0)
						System.out.println(Math.min(mA, cA));
				}
			} else {
				if (cA < cB) {
					long pB = (cA + 1) * mB;
					if (pB < cB)
						System.out.println((cA + pB));
					else
						System.out.println((cA + cB));
				} else {
					long pA = (cB + 1) * mA;
					if (pA < cA)
						System.out.println((cB + pA));
					else
						System.out.println((cB + cA));
				}
			}
		}
	}

}

class InputReader {
	BufferedReader reader;
	StringTokenizer tokenizer;

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