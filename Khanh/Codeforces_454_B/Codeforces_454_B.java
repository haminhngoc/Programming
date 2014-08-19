import java.util.Scanner;

public class Codeforces_454_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		int result = 0;
		int bot = FindBot(a, n);
		if (bot == 0)
			result = 0;
		else if (bot == n - 1) {
			if (a[n - 1] <= a[0])
				result = 1;
			else
				result = -1;
		} else {/*
				 * while(bot<n-1) { if ((a[bot] > a[bot + 1])||(a[bot]>a[0])) {
				 * result = -1; break; } bot++;
				 */
			for (int i = bot; i < n - 1; i++) {
				if ((a[i] > a[i + 1]) || (a[i] > a[0])) {
					result = -1;
					break;
				}
			}
			if (result != -1) {
				if (a[n - 1] <= a[0])
					result = n - bot;
				else
					result = -1;
			}
		}
		System.out.println(result);
		scan.close();
	}

	private static int FindBot(int[] a, int n) {
		// TODO Auto-generated method stub
		int i = 1;
		while (i < n) {
			if (a[i] < a[i - 1])
				return i;
			i++;
		}
		return 0;
	}
}
