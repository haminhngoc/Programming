import java.util.Scanner;

public class ValeraandTubes {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();
		solve(n, m, k);

	}

	private static void solve(int n, int m, int k) {
		int count = 0;
		int step = 1;
		int row = 1;
		int col = 1;
		for (; count < k - 1; ++count) {
			System.out.print("2 ");
			System.out.print(Integer.toString(row) + " "
					+ Integer.toString(col));
			col += step;
			if (col > m) {
				col = m;
				row++;
				step = -step;
			} else if (col < 1) {
				col = 1;
				row++;
				step = -step;
			}
			System.out.print(" " + Integer.toString(row) + " "
					+ Integer.toString(col));
			col += step;
			if (col > m) {
				col = m;
				row++;
				step = -step;
			} else if (col < 1) {
				col = 1;
				row++;
				step = -step;
			}
			System.out.println();
		}

		int leftCells = n * m - (k - 1) * 2;
		System.out.print(leftCells);
		while (row <= n) {
			System.out.print(" " + Integer.toString(row) + " "
					+ Integer.toString(col));
			col += step;
			if (col > m) {
				col = m;
				row++;
				step = -step;
			} else if (col < 1) {
				col = 1;
				row++;
				step = -step;
			}
		}
		System.out.println();
	}

}
