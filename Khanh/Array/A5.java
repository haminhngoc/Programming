import java.util.Scanner;

public class A5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		int max = 0, l = 0, r = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = n - 1; j > i; j--)
				if ((a[j] - a[i]) > max) {
					max = a[j] - a[i];
					l = i;
					r = j;
				}
		System.out.println(l + " " + r);
		scan.close();
	}

}
