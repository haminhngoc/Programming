import java.util.Scanner;

public class Codeforces_454_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		double r = 0;
		for (int i = 1; i <= m; i++) {
			r += i
					* (Math.pow((double) i / m, n) - Math.pow((double) (i - 1)
							/ m, n));
		}
		System.out.println(r);
		scan.close();
	}
}
