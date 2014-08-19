import java.util.Scanner;

public class Codeforces_426_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), s = scan.nextInt();
		int max = scan.nextInt();
		boolean result = true;
		for (int i = 1; i < n; i++) {
			int x = scan.nextInt();
			if (max < x) {
				s -= max;
				max = x;
			} else {
				s -= x;
			}
			if (s < 0) {
				result = false;
				break;
			}
		}
		if (result == true)
			System.out.println("YES");
		else
			System.out.println("NO");
		scan.close();
	}

}
