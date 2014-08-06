import java.util.Scanner;

public class Codeforces_435_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt();
		int countBus = 1, remain = m;
		int i = 0;
		while (i < n) {
			int x = scan.nextInt();
			if (x <= remain) {
				remain -= x;
			} else {
				remain = m - x;
				countBus++;
			}
			i++;
		}
		System.out.println(countBus);

		scan.close();
	}

}
