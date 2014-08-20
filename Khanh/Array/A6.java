import java.util.Scanner;

public class A6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		int arr[] = new int[n];
		a[0] = scan.nextInt();
		arr[0] = a[0];
		for (int i = 1; i < n; i++) {
			a[i] = scan.nextInt();
			arr[i] = a[i] + arr[i - 1];
		}
		int max = 0, l = 0, r = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = n - 1; j > i; j--)
				if ((arr[j] - arr[i]) > max) {
					max = arr[j] - arr[i];
					l = i;
					r = j;
				}
		System.out.println(l + " " + r);
		scan.close();
	}

}
