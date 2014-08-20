import java.util.Scanner;

public class Codeforces_427_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int offcr = 0, result = 0;
		for (int i = 0; i < n; i++) {
			int x = scan.nextInt();
			if (x<=10)
			offcr += x;
			else offcr+=10;
			if (offcr < 0) {
				offcr = 0;
				result++;
			}
			/*if (offcr > 10)
				offcr = 10;*/
		}
		System.out.println(result);
		scan.close();
	}

}
