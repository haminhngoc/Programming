import java.util.Scanner;

public class Codeforces_451_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt(), n = scan.nextInt();
		int totalInter;
		if (m > n)
			totalInter = n;
		else
			totalInter = m;
		if (totalInter % 2 == 0)
			System.out.println("Malvika");
		else
			System.out.println("Akshat");
		scan.close();
	}

}
