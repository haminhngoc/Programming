import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class BILL {

	static long[] arrCost = new long[4];
	static long[] arrBase = new long[4];

	public static void main(String[] args) {
		arrCost[0] = 200;
		arrCost[1] = 300;
		arrCost[2] = 500;
		arrCost[3] = 700;
		arrBase[0] = 0;
		arrBase[1] = 100;
		arrBase[2] = 10000;
		arrBase[3] = 1000000;

		InputReader in = new InputReader(System.in);
		long cSum = in.nextLong();
		long cDif = in.nextLong();

		long eSum = CalENum(cSum);
		long eN = eSum / 2;
		int x = 3;
		while (arrBase[x] > eN && x >= 0)
			x--;

		long Y = arrCost[x];
		while (Y >= 200) {
			long X = cDif / (arrCost[x] + Y);
			if (X < eN && (X * (arrCost[x] + Y) == cDif)) {
				System.out.print(CalBill(eN - X));
				return;
			}
			Y--;
		}

	}

	private static long CalBill(long x) {
		long r = 0;
		int base = 0;
		while (x > arrBase[base + 1]) {
			r += arrBase[base + 1] * arrCost[base];
			x -= arrBase[base + 1];
			base++;
		}
		r += x * arrCost[base];
		return r;
	}

	private static long CalENum(long cSum) {
		int base = 0;
		long r = 0;
		long lim = arrBase[base + 1] * arrCost[base];
		while (cSum > lim && base < 3) {
			cSum -= lim;
			base++;
			r += arrBase[base];
			lim = arrBase[base + 1] * arrCost[base];
		}
		r += cSum / arrCost[base];
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
}