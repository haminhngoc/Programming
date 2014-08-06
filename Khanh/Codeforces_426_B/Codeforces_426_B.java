import java.util.Scanner;

public class Codeforces_426_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt();
		String a[] = new String[n];
		for (int i = 0; i < n; i++) {
			int x, y = 0;
			a[i] = "";
			for (int j = 0; j < m; j++) {
				x = scan.nextInt();
				a[i] += x;
				y += x;
			}
			if (y == 0)
				a[i] = "0";
		}
		int result = Check(a, n);

		// for (int i = 0; i < n; i++)
		// System.out.println(a[i]);

		System.out.println(result);
		scan.close();
	}

	private static int Check(String[] a, int n) {
		// TODO Auto-generated method stub
		for (int i = 1; i <= n / 2; i++) {
			if (n % i == 0) {
				if (checkI(a, n, i) == true) {
					if (CheckArr(a, n, i) == true)
						return i;
				}
			}
		}
		return n;
	}

	private static boolean checkI(String[] a, int n, int i) {
		// TODO Auto-generated method stub
		int nullb = 1;
		for (int j = 0; j < i; j++)
			if (a[j].equals("0") == false)
				nullb = 0;
		if (nullb == 1)
			return false;
		for (int j = 0; j < i; j++)
			if (a[j].equals(a[2 * i - j - 1]) == false)
				return false;
		return true;
	}

	private static boolean CheckArr(String[] a, int n, int line) {
		// TODO Auto-generated method stub
		for (int i = 1; i < n / (2 * line); i++) {
			int baseI = i * 2 * line;
			for (int j = 0; j < line * 2; j++) {
				if (j < line) {
					if (a[baseI + j].equals(a[j]) == false)
						return false;
				}
			}
		}
		return true;
	}
}
