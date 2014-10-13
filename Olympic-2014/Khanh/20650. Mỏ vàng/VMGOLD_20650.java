import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class VMGOLD_20650 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream inputStream = System.in;
		InputReader20650 in = new InputReader20650(inputStream);

		Integer n = in.nextInt();
		int k = in.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextLong();
		}
		long r = Solve(arr, n, k);
		System.out.println(r);
	}

	private static long Solve(long[] arr, int n, int k) {
		ArrayList<Long> val = new ArrayList<Long>();
		for (int i = 0; i < n; i++) {
			Long I = arr[i];
			val.add(I);
			int sqrtAi = (int) Math.sqrt(I);
			for (int j = 2; j <= sqrtAi; j++)
				if (I % j == 0) {
					Long J = I / j;
					val.add(J);
					if (J != j)
						val.add((long) j);
				}
		}
		Collections.sort(val);

		int size = val.size();
		if (k == 1)
			return val.get(size - 1);
		Long x = val.get(size - 1);
		int count = 1;
		for (int i = size - 2; i >= 0; i--) {
			Long y = val.get(i);
			if (y == x) {
				count++;
				if (count >= k)
					return y;
			} else {
				count = 1;
				x = y;
			}
		}
		return 1;
	}
}

class InputReader20650 {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader20650(InputStream stream) {
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