import java.util.Scanner;

public class Codeforces_454_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for (int i = 1; i <= n; i++) {
			if (i <= (n / 2) + 1)
				print(n, n / 2 + 1 - i);
			if (i > (n / 2) + 1)
				print(n, i - ((n / 2) + 1));
			System.out.println("");
		}

		scan.close();
	}

	private static void print(int n, int i) {
		// TODO Auto-generated method stub
		for (int j = 1; j <= n; j++) {
			if ((j <= i) || (j > n - i))
				System.out.print('*');
			else
				System.out.print('D');
		}
	}

}
