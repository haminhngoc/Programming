import java.util.Scanner;

public class A7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n], k1 = scan.nextInt(), k2 = scan.nextInt();
		if (k1 > k2) {
			int t = k1;
			k1 = k2;
			k2 = t;
		}
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		boolean passK1 = false;
		int count = 0, max = 0, end = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] > k1)
				passK1 = true;
			if ((a[i] > k2) || (i == n - 1)) {
				if ((passK1 == true) && (count > max)) {
					max = count;
					end = i - 1;
					if (a[i] <= k2) {
						end++;
						max++;
					}
				}
				count = 0;
				passK1 = false;
			} else {
				count++;
			}
		}
		System.out.println(end - max + 1 + " " + end + " " + max);
		scan.close();
	}
}