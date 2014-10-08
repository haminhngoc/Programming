import java.util.Arrays;
import java.util.Scanner;

class VMGOLD_20650 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int k = scan.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = scan.nextInt();
		Arrays.sort(arr);
		int r = Check(arr, n, k);
		System.out.println(r);
		scan.close();
	}

	private static int Check(int[] arr, int n, int k) {
		// TODO Auto-generated method stub
		for (int j = arr[n - 1] / 2; j > 1; j--) {
			int r = CountDiv(arr, n, j);
			if (r >= k)
				return j;
		}
		return 1;
	}

	private static int CountDiv(int[] arr, int n, int j) {
		// TODO Auto-generated method stub
		int r = 0;
		boolean pos[] = new boolean[arr[n - 1] + 1];
		for (int i = j; i <= arr[n - 1]; i += j)
			pos[i] = true;
		for (int i = 0; i < n; i++)
			if (pos[arr[i]] == true)
				r++;
		return r;
	}

}
