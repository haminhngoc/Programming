import java.util.Scanner;

public class A2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n + 1];
		a[n] = -1;
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		int left = 0, start = 0, max = 0;
		while (a[left] < 0)
			left++;
		start = left;
		for (int i = left; i <= n; i++) {
			if (a[i] < 0) {
				if (max < (i - left)) {
					max = i - left;
					start = left;
				}
				left = i + 1;
			}
		}
		System.out.print(start + " " + (start + max - 1) + " " + max);
		scan.close();
	}

}
