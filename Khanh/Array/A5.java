import java.util.Scanner;

public class A5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		int max = Integer.MIN_VALUE, l = 0, r = 1, imin = 0, imax = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] > a[r]) {
				r = i;
				if (a[r] - a[l] > max) {
					imin = l;
					imax = r;
				}
			}
			if (a[i] < a[l]) {
				if (a[r] - a[l] > max) {
					imin = l;
					imax = r;
					max = a[r] - a[l];
				}
				l = i;
				if (i < n - 1)
					r = i + 1;
			}
		}

		if (imax == 0)
			imax = 1;
		System.out.println(imin + " " + imax);
		scan.close();
	}

}
