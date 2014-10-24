import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class CWAY {

	public static void main(String[] args) {
		InputReader in = new InputReader(System.in);
		int N = in.nextInt();
		BigNumber[] arr = new BigNumber[N];
		arr[0] = new BigNumber(1);
		int D = N - 2;
		for (int i = 1; i <= D; ++i) {
			arr[i] = arr[i - 1];
			arr[i].multiple(D + 1 - i);
		}

		BigNumber r = new BigNumber(0);
		for (int i = 0; i <= D; ++i)
			r.plus(arr[i]);
		
		System.out.println();
		for(int i=0; i<=r.n; i++)System.out.print(r.number[i]);
	}

}

class BigNumber {
	public int[] number = new int[1001];
	public int n = 0;

	public BigNumber(int x) {
		for (int i = 0; i < 1001; ++i)
			number[i] = 0;
		int j = 0;
		while (x > 1000) {
			number[n] = x % 1000;
			x /= 1000;
			j++;
		}
		n = j;
		number[n] = x;
	}

	public void plus(BigNumber x) {
		int N = Math.max(n, x.n);
		number[0] += x.number[0];
		if (N > 0) {
			for (int i = 1; i <= N; i++)
				number[i] += (number[i - 1] / 1000 + x.number[i]);
			if (number[N] > 1000) {
				n = N + 1;
				number[n] += number[N] / 1000;
			} else
				n = N;
		} else {
			number[1] += number[0] / 1000;
			if (number[0] > 1000) {
				number[1] += number[0] / 1000;
				n = 1;
			}
		}
	}

	public void multiple(int x) {

		number[0] *= x;
		if (n > 0) {
			for (int i = 1; i <= n; i++)
				number[i] = (number[i - 1] / 1000 + number[i] * x);
			if (number[n] > 1000) {
				n++;
				number[n] += number[n - 1] / 1000;
			}
		} else {
			if (number[0] > 1000) {
				number[1] += number[0] / 1000;
				n = 1;
			}
		}
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