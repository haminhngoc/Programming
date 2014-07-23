import java.util.Scanner;

public class Codeforces_448_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int sCups = 0, sMedals = 0;
		for (int i = 0; i < 3; i++)
			sCups += scan.nextInt();
		for (int i = 0; i < 3; i++)
			sMedals += scan.nextInt();
		int n = scan.nextInt();
		int sShelves = 0;
		if (sCups % 5 == 0)
			sShelves += sCups / 5;
		else
			sShelves += (sCups / 5 + 1);
		if (sMedals % 10 == 0)
			sShelves += sMedals / 10;
		else
			sShelves += (sMedals / 10 + 1);
		if (n >= sShelves)
			System.out.print("YES");
		else
			System.out.print("NO");
		scan.close();
	}

}
