import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {

	static long result = 0;
	static long r;
	static long l;

	public static void main(String[] args) {
		int n = nextInt();
		l = nextInt();
		r = nextInt();
		Long[] arr = new Long[n];
		long t = 0;
		for (int i = 0; i < n; ++i) {
			t += nextLong();
			arr[i] = t;
		}

		int k = 1;
		solve(arr, 0, n - 1);
		
		System.out.println(result);

	}

	private static void solve(Long[] arr, int i, int j) {
		if (i == j) {
			if (arr[i] <= r && arr[i] >= l) {
				result++;
			}
			return;
		}
		int mid = (i + j) / 2;
		solve(arr, i, mid);
		solve(arr, mid + 1, j);
		Arrays.sort(arr, i, mid + 1);
		Arrays.sort(arr, mid + 1, j + 1);

		for (int k = mid + 1; k <= j; ++j) {
			long tL = arr[k] - l;
			long tR = arr[k] - r;
			int iL = lowerBound(arr, tR);
			int iR = upperBound(arr, tL);

			if (iL == -1 || iR == -1) {
				result += iL - iR + 1;
			}
		}

	}

	private static int upperBound(Long[] arr, long tL) {
		int rr = arr.length - 1;
		int lr = 0;
		while (lr != rr) {
			int mid = (rr + lr) / 2;
			if (arr[mid] < tL) {
				lr = mid + 1;
			} else {
				rr = mid;
			}
		}

		if (arr[lr] < tL) {
			return -1;
		}

		return lr;
	}

	private static int lowerBound(Long[] arr, long tR) {
		int rr = arr.length - 1;
		int lr = 0;
		while (lr != rr) {
			int mid = (rr + lr + 1) / 2;
			if (arr[mid] > tR) {
				rr = mid - 1;
			} else {
				lr = mid;
			}
		}
		if (arr[lr] > tR) {
			return lr - 1;
		}
		return lr;
	}

	public static InputStream in = System.in;
	public static byte[] bytes = new byte[1024];
	public static int lenbuf = 0;
	public static int prtbuf = 0;

	public static int readByte() {
		if (lenbuf == -1) {
			throw new InputMismatchException();
		}
		if (prtbuf >= lenbuf) {
			prtbuf = 0;
			try {
				lenbuf = in.read(bytes);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new InputMismatchException();
			}
			if (lenbuf <= 0) {
				return -1;
			}
		}

		return bytes[prtbuf++];
	}

	public static int read() {
		int b;
		while ((b = readByte()) != -1 && isSpace(b))
			;
		return b;

	}

	private static boolean isSpace(int b) {
		return !(b >= 33 && b <= 126);

	}

	private static String nextString() {
		StringBuilder str = new StringBuilder();
		int b = read();
		while (!isSpace(b)) {
			str.appendCodePoint(b);
			b = readByte();
		}
		return str.toString();
	}

	private static int nextInt() {
		return Integer.parseInt(nextString());
	}

	private static long nextLong() {
		return Long.parseLong(nextString());
	}

}
