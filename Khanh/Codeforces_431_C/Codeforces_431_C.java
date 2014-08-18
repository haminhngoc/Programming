import java.util.Scanner;

public class Codeforces_431_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), k = scan.nextInt(), d = scan.nextInt();
		int arr[] = new int[n + 1];
		arr[0] = 1;
		arr[1] = 1;
		if (n > 1)
			for (int i = 2; i <= n; i++) {
				arr[i] = 0;
				for (int j = 1; j <= k; j++)
					if (i >= j)
						arr[i] += arr[i - j];
			}
		int result = Check(n, arr, k, d);
		System.out.println(result);
		scan.close();
	}

	private static int Check(int n, int[] arr, int k, int d) {
		// TODO Auto-generated method stub
		int r = 0;
		if (n < d)
			return 0;
		else {
			for (int i = 1; i <= k; i++) {
				if (i < d)
					r += Check(n - i, arr, k, d);
				else if (n >= i)
					r += arr[n - i];
			}
		}
		return r;
	}

}
