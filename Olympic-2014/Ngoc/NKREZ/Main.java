import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.StringTokenizer;
import java.io.InputStream;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		NKREZ solver = new NKREZ();
		solver.solve(1, in, out);
		out.close();
	}
}

class NKREZ {
	/* Complexity: MAX + O(n). Why?
	 * Run MainTest to generate large testcase (1M)
	 */
	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int MAX = 30000 + 1;
		int[] maxValues = new int[MAX];

		int n = in.ni();
		Record[] records = new Record[n];

		for (int i = 0; i < n; i++) {
			Record record = new Record();
			record.start = in.ni();
			record.end = in.ni();
			records[i] = record;
		}

		Arrays.sort(records);
		
		int j = 0;
		int i = 1;
		for (i = 1; i < MAX; i++) {
			maxValues[i] = maxValues[i - 1];

			while (j < n && records[j].end == i) {
				int start = records[j].start;
				maxValues[i] = Math.max(maxValues[i], maxValues[start] + i - start);
				j++;
			}

			if (j == n) {
				i++;
				break;
			}
		}

		out.println(maxValues[i - 1]);
	}
}

class Record implements Comparable<Record> {
	public int start;
	public int end;

	public int compareTo(Record arg0) {
		return end - arg0.end;
	}
}

class InputReader {
	InputStream is;
	byte[] inbuf = new byte[1024];
	int lenbuf = 0, ptrbuf = 0;

	public InputReader(InputStream stream) {
		is = stream;
	}

	int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	double nd() {
		return Double.parseDouble(ns());
	}

	char nc() {
		return (char) skip();
	}

	String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	int ni() {
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

}

/*
out.println("=====================================");
for (int i = 0; i < n; i++) {
	out.println(records[i].start + " " + records[i].end);
}
out.println("=====================================");
*/
