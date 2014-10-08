import java.util.Scanner;

class Point12770 {
	int x = 0;
	int y = 0;

	public Point12770() {
	};

	public Point12770(int _x, int _y) {
		x = _x;
		y = _y;
	}

	double getRange(Point12770 b) {
		double result = 0;
		result = Math.sqrt(Math.pow(x - b.x, 2) + Math.pow(y - b.y, 2));
		return result;
	}
}

class C11TRCNT_12770 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		Point12770 a[] = new Point12770[n];
		for (int i = 0; i < n; i++)
			a[i] = new Point12770(scan.nextInt(), scan.nextInt());

		int min = 201;
		int iMin = 0;
		int size = 0;
		int count[] = new int[n];
		for (int i = 0; i < n; i++)
			count[i] = 0;

		for (int i = 0; i < n - 2; i++) {
			for (int j = i + 1; j < n - 1; j++)
				for (int k = j + 1; k < n; k++) {
					double sA = a[i].getRange(a[j]);
					double sB = a[j].getRange(a[k]);
					double sC = a[k].getRange(a[i]);
					if (sA < sB + sC && sB < sA + sC && sC < sA + sB) {
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
		scan.close();
	}
}
