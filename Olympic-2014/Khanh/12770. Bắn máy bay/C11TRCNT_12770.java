import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Point12770 {
	int x = 0;
	int y = 0;

	public Point12770() {
	};

	public Point12770(int _x, int _y) {
		x = _x;
		y = _y;
	}
}

class C11TRCNT_12770 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream inputStream = System.in;
		InputReader12770 in = new InputReader12770(inputStream);

		int n = in.nextInt();
		Point12770 a[] = new Point12770[n];
		for (int i = 0; i < n; i++)
			a[i] = new Point12770(in.nextInt(), in.nextInt());

		int min = Integer.MAX_VALUE;
		int iMin = 0;
		int size = 0;
		int count[] = new int[n];
		for (int i = 0; i < n; i++)
			count[i] = 0;

		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++)
				for (int k = j + 1; k < n; k++) {
					if (a[i].x * (a[j].y - a[k].y) + a[j].x * (a[k].y - a[i].y)
							+ a[k].x * (a[i].y - a[j].y) != 0) {
						size++;
						count[i]++;
						count[j]++;
						count[k]++;
					}
				}
			if (min > count[i]) {
				min = count[i];
				iMin = i + 1;
			}
		}
		System.out.print(size + " " + iMin);
	}
}

class InputReader12770 {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader12770(InputStream stream) {
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
