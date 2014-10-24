import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class problemJ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader in = new InputReader(System.in);
		int T = in.nextInt();
		for (int iT = 0; iT < T; ++iT) {
			int M = in.nextInt();
			int maxCalo = in.nextInt();
			int maxMeal = in.nextInt();
			int[] arrM = new int[M];
			for (int i = 0; i < M; ++i)
				arrM[i] = in.nextInt();
			int r = Check(M, arrM, maxCalo, maxMeal);
			if (r == maxMeal)
				System.out.println("ENOUGH");
			else
				System.out.println(r);
		}
	}

	private static int Check(int m, int[] arrM, int maxCalo, int maxMeal) {
		int r = 0;
		Arrays.sort(arrM);
		for (int i = m - 1; i > 0; --i) {
			if (arrM[i] == maxCalo) {
				// System.out.println(arrM[i] + "=maxCalo");
				r++;
			}
			if (arrM[i] < maxCalo) {
				// System.out.println(arrM[i]);
				r += findMeal(arrM, 0, i - 1, maxCalo - arrM[i]);
			}
			if (r >= maxMeal)
				return maxMeal;
		}
		return r;
	}

	private static int findMeal(int[] arrM, int left, int right, int max) {
		int r = 0;
		for (int i = left; i <= right; ++i) {
			if (arrM[i] > max) {
				// System.out.println("+" + arrM[i] + ">maxCalo");
				return r;
			}
			if (arrM[i] == max) {
				// System.out.println("+" + arrM[i] + "=maxCalo");
				r++;
			}
			// System.out.print("+" + arrM[i]);
			r += findMeal(arrM, i + 1, right, max - arrM[i]);
		}
		return r;
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