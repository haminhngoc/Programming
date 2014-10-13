import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		Init(System.in);

		int n = nextInt();
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		long sum = 0;
		long count = n;
		long arr[] = new long[n];
		int size = 0;
		long temp;
		for (int i = 0; i < n; ++i) {
			temp = nextLong();
			if (temp <= 0) {
				count--;
				while (size > 0 && sum + temp - q.peek().value <= 0) {
					q.poll();
					count--;
					size--;
				}
			} else {
				Pair p = new Pair();
				p.position = i;
				p.value = sum;
				q.add(p);
				size++;
			}

			sum += temp;
			arr[i] = sum;
		}
		for (int i = 1; i < n; ++i) {
			while (size > 0) {
				Pair p = q.peek();
				if (p.position < i) {
					q.poll();
					size--;
					continue;
				}
				if (sum - p.value + arr[i - 1] <= 0) {
					q.poll();
					size--;
					count--;
				} else {
					break;
				}
			}
		}
		System.out.println(count);
	}

	static BufferedReader reader;
	static StringTokenizer tokenizer;

	static void Init(InputStream input) {
		reader = new BufferedReader(new InputStreamReader(input));
		tokenizer = new StringTokenizer("");
	}

	static InputStream is = System.in;
	static private byte[] buffer = new byte[1024];
	static private int lenbuf = 0, ptrbuf = 0;

	static private int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(buffer);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return buffer[ptrbuf++];
	}

	static private boolean isSpace(int c) {
		return !(c >= 33 && c <= 126);
	}

	static private int read() {
		int b;
		while ((b = readByte()) != -1 && isSpace(b))
			;
		return b;
	}

	static private double nextDouble() {
		return Double.parseDouble(nextString());
	}

	static private char nextChar() {
		return (char) read();
	}

	static private String nextString() {
		int b = read();
		StringBuilder sb = new StringBuilder();
		while (!(isSpace(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	static private char[] nextString(int n) {
		char[] buf = new char[n];
		int b = read(), p = 0;
		while (p < n && !(isSpace(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	static private int nextInt() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static private long nextLong() {
		long num = 0;
		int b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

	static private int[] nextAi(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}

	static private Integer[] nextAi1(int n) {
		Integer[] a = new Integer[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
	}
}

class Pair implements Comparable<Pair> {
	int position;
	long value;

	@Override
	public int compareTo(Pair arg0) {
		return this.value < arg0.value ? 1 : (this.value > arg0.value ? -1 : 0);
	}
}
