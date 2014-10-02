import java.util.Random;
import java.util.Scanner;

public class C11TRCNT {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		//Random rd = new Random();
		point[] p = new point[n];
		int[] count = new int[n];
		for (int i = 0; i < n; i++) {
			point tmp = new point();
			tmp.x = reader.nextLong();
			tmp.y = reader.nextLong();
			//tmp.x=rd.nextLong();
			//tmp.y=rd.nextLong();
			
			p[i] = tmp;

		}
		int result = 0;
		for (int i = 0; i < n - 2; i++)
			for (int j = i + 1; j < n - 1; j++)
				for (int k = j + 1; k < n; k++) {
					if (Check(p[i], p[j], p[k]) == true) {
						count[i]++;
						count[j]++;
						count[k]++;
						//System.out.println(i+" "+j+" "+k);
					} else
						result++;

				}
		// System.out.println(result);
		int index = 0;
		long max = 0;
		for (int i = 0; i < n; i++)
			if (count[i] > max) {
				max = count[i];
				index = i;
			}
		System.out.println(result + " " + (index + 1));
		// System.out.println(CheckTriangle(p[0], p[1], p[2]));

	}

	public static boolean Check(point a, point b, point c) {

		point A = new point();
		point B = new point();
		point tmp = new point();
		A.x = (b.x - a.x);
		A.y = (b.y - a.y);
		B.x = (c.x - a.x);
		B.y = (c.y - a.y);
		if (B.x > A.x) {
			tmp = A;
			A = B;
			B = tmp;

		}
		if (A.x == 0 && B.x == 0)
			return true;
		else if (A.y == 0 && B.y == 0)
			return true;
		else if (A.x != 0 && A.y != 0 && B.x != 0 && B.y != 0) {
			if (A.x / B.x == A.y / B.y && A.x % B.x == 0)
			return true;
		}
		return false;
	}

}

class point {
	long x;
	long y;
}
