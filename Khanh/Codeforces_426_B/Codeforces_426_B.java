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
		int result=n;
		int N=n;
		while(N%2==0)
		{
			if (Check(a, n, N)==false)
			{
					result=N;
					N--;
			}
			else
			{
				result=N/2;
				N=N/2;
			}
		}
		
		
		System.out.println(result);
		scan.close();
	}

	private static boolean Check(String[] a, int n, int m) {
		// TODO Auto-generated method stub
			for (int i = 0; i < m / 2; i++)
				if (a[i].equals(a[m - 1 - i]) == false)
					return false;
		return true;
	}
}
