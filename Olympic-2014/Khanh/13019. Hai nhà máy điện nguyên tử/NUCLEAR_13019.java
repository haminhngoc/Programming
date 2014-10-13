import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point {
	int x = 0;
	int y = 0;

	public Point() {
	};

	public Point(int _x, int _y) {
		x = _x;
		y = _y;
	}

	double getRange(Point b) {
		double result = 0;
		result = Math.sqrt(Math.pow(x - b.x, 2) + Math.pow(y - b.y, 2));
		return result;
	}
}

class NUCLEAR_13019 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader13019 in = new InputReader13019(System.in);

		int n = in.nextInt();
		Point arr[] = new Point[n];
		for (int iN = 0; iN < n; iN++) {
			arr[iN] = new Point(in.nextInt(), in.nextInt());
		}
		Point facA = new Point(in.nextInt(), in.nextInt());
		Point facB = new Point(in.nextInt(), in.nextInt());
		double arrRangeA[] = new double[n];
		double arrRangeB[] = new double[n];
		for (int iN = 0; iN < n; iN++) {
			arrRangeA[iN] = arr[iN].getRange(facA);
			arrRangeB[iN] = arr[iN].getRange(facB);
		}
		int T = in.nextInt();
		for (int iT = 0; iT < T; iT++) {
			int r1 = in.nextInt();
			int r2 = in.nextInt();
			System.out.println(Check(n, arrRangeA, arrRangeB, r1, r2));
		}
	}

	private static int Check(int n, double[] arrRangeA, double[] arrRangeB,
			int r1, int r2) {
		int result = 0;
		for (int i = 0; i < n; i++)
			if (arrRangeA[i] <= r1 || arrRangeB[i] <= r2)
				result++;
		return result;
	}
}

class InputReader13019 {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader13019(InputStream stream) {
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