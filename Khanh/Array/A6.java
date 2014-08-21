import java.util.Scanner;

public class A6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		int arr[] = new int[n];
		arr[0] = scan.nextInt();
		a[0] = arr[0];
		for (int i = 1; i < n; i++) {
			arr[i] = scan.nextInt();
			a[i] = arr[i] + a[i - 1];
		}
		int max = 0, l = 0, r = 0, imin = 0, imax = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] > a[r])
				r = i;
			if (a[i] < a[l]) {
				if (a[r] - a[l] > max) {
					imin = l;
					imax = r;
					max = a[r] - a[l];
				}
				l = i;
				r = i;
			}
		}
		if (a[r] - a[l] > max) {
			imin = l;
			imax = r;
		}
		System.out.println(imin + " " + imax);
		scan.close();
	}

}
