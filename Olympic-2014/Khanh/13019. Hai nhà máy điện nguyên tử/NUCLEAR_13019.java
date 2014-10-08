import java.util.Scanner;

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
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Point arr[] = new Point[n];
		for (int iN = 0; iN < n; iN++) {
			arr[iN] = new Point(scan.nextInt(), scan.nextInt());
		}
		Point facA = new Point(scan.nextInt(), scan.nextInt());
		Point facB = new Point(scan.nextInt(), scan.nextInt());
		double arrRangeA[] = new double[n];
		double arrRangeB[] = new double[n];
		for (int iN = 0; iN < n; iN++) {
			arrRangeA[iN] = arr[iN].getRange(facA);
			arrRangeB[iN] = arr[iN].getRange(facB);
		}
		int T = scan.nextInt();
		for (int iT = 0; iT < T; iT++) {
			int r1 = scan.nextInt();
			int r2 = scan.nextInt();
			System.out.println(Check(n, arrRangeA, arrRangeB, r1, r2));
		}
		scan.close();
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
