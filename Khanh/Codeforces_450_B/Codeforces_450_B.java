import java.util.Scanner;

public class Codeforces_450_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int x = scan.nextInt();
		int y = scan.nextInt();
		int n = scan.nextInt();
		System.out.print(calResult(x, y, n));

		scan.close();
	}

	private static int calResult(int x, int y, int n) {
		// TODO Auto-generated method stub
		int z = 0;
		if (n == 1)
			z = x;
		if (n == 2)
			z = y;
		for (int i = 2; i < n; i++) {
			z = y - x;
			x = y;
			y = z;
		}
		while (z<0)
			{
				z+=1000000007;
			}
			
			return z % 1000000007;
	}
}
