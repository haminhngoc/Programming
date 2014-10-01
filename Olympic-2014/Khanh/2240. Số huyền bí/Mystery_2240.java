import java.util.Scanner;

class Mystery_2240 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int n = 0;
		int x = 20122007;
		long arr[] = new long[a];
		for (int i = 1; i <= a; i++)
			if (a % i == 0) {
				arr[n] = i;
				n++;
			}
		for (int i = 0; i < n; i++) {
			long y = (long)(Math.pow(3, arr[i]) - 1) % x;
			arr[i] = y;
		}
		while (n > 1) {
			for (int i = 0; i < n / 2; i++) {
				long y = (arr[i] * arr[n - i - 1]) % x;
				arr[i] = y;
			}
			n = (n + 1) / 2;
		}
		System.out.println(arr[0]);
		scan.close();
	}
}
