import java.util.Scanner;

public class A1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n + 1];
		a[n] = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		int left = 0, start = 0, max = 1;
		for (int i = 1; i <= n; i++) {
			if (a[i] < a[i - 1]) {
				if (max < (i - left)) {
					max = i - left;
					start = left;
				}
				left = i;
			}
		}
		System.out.print(start + " " + (start + max - 1) + " " + max);
		scan.close();
	}

}
