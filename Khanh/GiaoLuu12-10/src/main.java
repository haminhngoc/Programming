import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class box {
	float a = 0;
	float b = 0;
	float c = 0;

	public box() {
	}

	public box(float _a, float _b, float _c) {
		a = _a;
		b = _b;
		c = _c;
	}

	void arrange() {
		float[] arr = new float[3];
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		Arrays.sort(arr);
		a = arr[0];
		b = arr[1];
		c = arr[2];
	}
}

class main {

	private static final InputStream inputStream = System.in;
	private static final InputReader in = new InputReader(inputStream);

	public static void main(String[] args) {
		 solveA();
		// solveD();
		// solveG();
		// solveJ();

	}

	private static void solveG() {
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			box A = new box(in.nextFloat(), in.nextFloat(), in.nextFloat());
			box B = new box(in.nextFloat(), in.nextFloat(), in.nextFloat());
			box C = new box(in.nextFloat(), in.nextFloat(), in.nextFloat());
			A.arrange();
			B.arrange();
			C.arrange();
			if (CheckG(A, B, C) == true)
				System.out.println("TRUE");
			else
				System.out.println("FALSE");
		}
	}

	private static boolean CheckG(box A, box B, box C) {
		if (A.c == B.c && B.c == C.c) {
			if (A.b == B.b && B.b == C.b && C.b == C.c
					&& A.a + B.a + C.a == C.c)
				return true;
			if (A.a == B.a) {
				if (A.b + B.b == C.c && A.a + C.a == C.c)
					return true;
			}
			if (A.a == B.b) {
				if (A.b + B.a == C.c && A.a + C.a == C.c)
					return true;
			}
			if (A.b == B.a) {
				if (A.a + B.b == C.c && A.b + C.a == C.c)
					return true;
			}
			if (A.b == B.b) {
				if (A.a + B.a == C.c && A.b + C.a == C.c)
					return true;
			}
		}
		return false;
	}

	private static void solveD() {
		long arr[] = new long[91];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i < 91; i++)
			arr[i] = arr[i - 1] + arr[i - 2];
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int N = in.nextInt();
			System.out.println(arr[N]);
		}

	}

	private static void solveA() {
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			long X = in.nextLong();
			System.out.println(CheckA(X));
		}

	}

	private static long CheckA(long x) {
		if (x < 10)
			return x + 1;
		long r = 2;
		while (r < x) {
			if (x % r == 0)
				r++;
			else {
				long a = x % r;
				long y = a;
				int i = 0;
				String s = "" + r;
				int size = s.length();
				if (a < Math.sqrt(x))
					while (y <= x) {
						if (y == x)
							return r;
						else {
							i++;
							if (size * i - i < 15)
								y += a * (long) Math.pow(r, i);
							else
								y = x + 1;
						}
					}
				r++;
			}
		}
		return 0;
	}

	private static void solveJ() {
		int N = in.nextInt();
		for (int i = 0; i < N; i++) {
			String s = in.next();
			System.out.println(CheckJ(s));
		}
	}

	private static int CheckJ(String s) {
		int size = s.length();
		int x5[] = new int[size + 1];
		int x2[] = new int[size + 1];
		x5[0] = 0;
		x2[0] = 0;

		int[] charMap = new int[26];
		for (int i = 0; i < 26; i++)
			charMap[i] = 0;

		for (int i = 1; i <= size; i++) {
			x5[i] = x5[i - 1] + FindNumber(5, i);
			x2[i] = x2[i - 1] + FindNumber(2, i);
		}
		int count5 = x5[size];
		int count2 = x2[size];

		for (int i = 0; i < size; i++)
			charMap[(int) s.charAt(i) - (int) 'A']++;

		for (int i = 0; i < 26; i++) {
			count5 -= x5[charMap[i]];
			count2 -= x2[charMap[i]];
		}

		return Math.min(count5, count2);
	}

	private static int FindNumber(int x, int n) {
		int r = 0;
		while (n > 0) {
			if (n % x == 0) {
				r++;
				n /= x;
			} else
				n = 0;
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

	public long nextLong() {
		return Long.parseLong(next());
	}

	public float nextFloat() {
		return Float.parseFloat(next());
	}
}