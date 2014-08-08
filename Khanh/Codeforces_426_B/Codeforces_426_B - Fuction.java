import java.util.Scanner;

public class Codeforces_426_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt();
		String a[] = new String[n];
		for (int i = 0; i < n; i++) {
			int x;
			a[i] = "";
			for (int j = 0; j < m; j++) {
				x = scan.nextInt();
				a[i] += x;
			}
		}
		int result = Check(a, n, n);
		System.out.println(result);
		scan.close();
	}

	private static int Check(String[] a, int n, int m) {
		// TODO Auto-generated method stub
		if (m % 2 == 0) {
			for (int i = 0; i < m / 2; i++) {
				if (a[i].equals(a[m - 1 - i]) == false)
					return m;
			}
			return Check(a, n, m / 2);
		}
		return m;
	}
}
