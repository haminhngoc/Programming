import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

class Main {

	public static void main(String[] args) {

		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Task solver = new Task();
		solver.solve(in, out);
		out.close();
	}
}

class Task {

	public void solve(InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int c = 1;
		while (n != 0) {
			List<House> list = new ArrayList<House>();
			House temp;
			for (int i = 0; i < n; ++i) {
				temp = new House();
				temp.x = in.nextInt();
				temp.y = in.nextInt();
				list.add(temp);
			}
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			List<Double> r1 = new ArrayList<Double>();
			List<Double> r2 = new ArrayList<Double>();
			for (int i = 0; i < n; ++i) {
				int x = list.get(i).x;
				int y = list.get(i).y;
				r1.add(Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1)));
				r2.add(Math.sqrt((x - x2) * (x - x2) + (y - y2) * (y - y2)));
			}

			Collections.sort(r1);
			Collections.sort(r2);
			int q = in.nextInt();
			long count = 0;
			System.out.println("Case " + c + ":");
			for (int i = 0; i < q; ++i) {
				int R1 = in.nextInt();
				int R2 = in.nextInt();

				count += BinarySearch(r1, R1);
				count += BinarySearch(r2, R2);
				System.out.println(Math.max(0, n - count));
				count = 0;
			}

			c++;
			n = in.nextInt();
		}
	}

	public static Integer BinarySearch(List<Double> r1, int value) {
		int left = 0;
		int right = r1.size() - 1;
		if (value >= r1.get(right)) {
			return right + 1;
		} else if (value < r1.get(0)) {
			return 0;
		}
		while (left != right) {
			int mid = (left + right + 1) / 2;
			if (r1.get(mid) > value) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		return r1.get(left) <= value ? left + 1 : left;
	}
}

class House {
	public int x;
	public int y;
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

	public double nextDouble() {
		return Double.parseDouble(next());
	}

}
