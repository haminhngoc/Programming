import java.util.Scanner;

public class Codeforces_435_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		int n = s.length();
		char a[] = new char[n];
		a = s.toCharArray();
		int k = scan.nextInt(), iChar = 0;
		while ((k > 0)&&(iChar<n)) {
			int iMax;
			if (k >= n - iChar) {
				iMax = FindMax(a, iChar, n - 1);
			} else {
				iMax = FindMax(a, iChar, k + iChar);
			}
			if (iMax > iChar) {
				k -= (iMax - iChar);
				for (int i = iMax; i > iChar; i--) {
					char temp = a[i];
					a[i] = a[i - 1];
					a[i - 1] = temp;
				}
			}
			iChar++;
		}
		for (int i = 0; i < n; i++)
			System.out.print(a[i]);
		scan.close();
	}

	private static int FindMax(char[] a, int iChar, int n) {
		// TODO Auto-generated method stub
		int iMax = iChar;
		for (int i = iChar; i <= n; i++)
			if ((int) a[i] > (int) a[iMax])
				iMax = i;
		return iMax;
	}

}
