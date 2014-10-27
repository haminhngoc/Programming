import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.nio.file.FileSystem;

import javax.imageio.stream.FileImageInputStream;

public class Main {
	static boolean OLP = false;

	public static void main(String[] args) throws FileNotFoundException {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		if (OLP) {
			inputStream = new FileInputStream("D:\\input.txt");
			outputStream = new FileOutputStream("D:\\output.txt");
		}
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskSPOJ solver = new TaskSPOJ();
		solver.solve(in, out);
		out.close();
	}
}

class TaskSPOJ {
	public void solve(InputReader in, PrintWriter out) {
		long x = in.nextLong();
		long y = in.nextLong();
		long c1, c2, c3, c4;
		c1 = c2 = c3 = c4 = 0;
		if (x > 100 * 200) {
			c1 = 100;
		} else {
			c1 = x / 200;
		}
		if (x > 100 * 200 + (10000 - 100) * 300) {
			c2 = 9900;
		} else if (x > 100 * 200) {
			c2 = (x - 100 * 200) / 300;
		}
		if (x > 100 * 200 + (10000 - 100) * 300 + (1000000 - 10000) * 500) {
			c3 = 1000000 - 10000;
		} else if (x > 100 * 200 + (10000 - 100) * 300) {
			c3 = (x - 100 * 200 - (10000 - 100) * 300) / 500;
		}
		if (x > 100 * 200 + (10000 - 100) * 300 + (1000000 - 10000) * 500) {
			c4 = (x - 100 * 200 - (10000 - 100) * 300 - (1000000 - 10000) * 500) / 700;
		}
		long total = c1 + c2 + c3 + c4;
		long c = 0;
		long cother;

		for (int i = 0; i <= total; ++i) {
			c = cal(i);
			cother = cal(total - i);
			if (cother - c == y) {
				out.println(c);
				return;
			}
		}
	}

	long cal(long i) {
		long c;
		c = 0;
		if (i > 100) {
			c += 100 * 200;
		} else {
			c = i * 200;
		}
		if (i > 10000) {
			c += 300 * (10000 - 100);
		} else if (i > 100) {
			c += (i - 100) * 300;
		}
		if (i > 1000000) {
			c += 500 * (1000000 - 10000);
		} else if (i > 10000) {
			c += (i - 10000)*500;
		}
		if (i > 1000000) {
			c += (i - 1000000) * 700;
		}
		return c;
	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}

	public InputReader(FileInputStream stream) {
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
