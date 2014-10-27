import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) throws IOException {
		in = new FileInputStream("text.txt");
		int n = nextInt();
		int d = nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; ++i) {
			a[i] = nextInt();
		}

		int[] t = new int[n + 1];
		Arrays.fill(t, Integer.MIN_VALUE);
		int min = Integer.MIN_VALUE;
		for (int i = 0; i < n; ++i) {

			for (int j = i; j > 0; --j) {
				if (t[j] == min || t[j] > a[i] + d) {
					continue;
				}
				t[j + 1] = Math.max(t[j], a[i] - d);
			}
			t[1] = t[1] == min ? a[i] - d : Math.min(t[1], a[i] - d);
		}
		
		for(int i = n; i>=0; --i){
			if(t[i]!=min){
				FileWriter fw  =  new FileWriter("out.txt");
				fw.write(i+"");
				fw.close();
				return;
			}
		}

	}

	public static FileInputStream in;//System.in;
	public static byte[] bytes = new byte[1024];
	public static int lenbuf = 0;
	public static int ptrbuf = 0;

	public static int readByte() {
		if (lenbuf == -1) {
			throw new InputMismatchException();
		}
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = in.read(bytes);
			} catch (IOException e) {
				throw new InputMismatchException();
			}

			if (lenbuf == 0) {
				return -1;
			}
		}

		return bytes[ptrbuf++];
	}

	public static boolean isSpace(int c) {
		return !(c >= 33 & c <= 126);
	}

	public static int read() {
		int b;
		while ((b = readByte()) != -1 && (isSpace(b)))
			;
		return b;
	}

	public static String nextString() {
		int b = read();
		StringBuilder str = new StringBuilder();
		while (!(isSpace(b))) {
			str.appendCodePoint(b);
			b = readByte();
		}

		return str.toString();

	}

	public static char nextChar() {
		return (char) read();

	}

	public static double nextDouble() {
		return Double.parseDouble(nextString());

	}

	public static int nextInt() {
		return Integer.parseInt(nextString());

		/*
		 * int b; boolean minus = false; while ((b = readByte()) != -1 && !((b
		 * >= '0' && b <= '9') || b == '-')) ; if (b == '-') { minus = true; b =
		 * readByte(); } int num = 0; while (true) { if (b >= '0' && b <= '9') {
		 * num = num * 10 + (b - '0'); }else{ return minus?-num:num; } b =
		 * readByte();
		 * 
		 * }
		 */

	}

	public static long nextLong() {
		int b;
		return Long.parseLong(nextString());

	}
}
