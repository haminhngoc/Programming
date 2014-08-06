import java.util.Arrays;
import java.util.Scanner;

public class Codeforces_433_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] w = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			w[i] = scan.nextInt();
			sum += w[i];
		}
		sum = sum / 2;
		if(CheckHaft(w,n,sum)==true)System.out.print("YES");
		else System.out.print("NO");
		scan.close();
	}

	private static boolean CheckHaft(int[] w, int n, int sum) {
		// TODO Auto-generated method stub
		if (sum % 100 > 0)
			return false;
		else {
			int sumHaft = 0;
			Arrays.sort(w);
			for (int i = n - 1; i > 0; i--) {
				sumHaft += w[i];
				if ((sumHaft == sum) || (sumHaft == (sum - w[0])))
					return true;
			}
		}
		return false;
	}

}
