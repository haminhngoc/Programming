import java.util.Scanner;

public class Codeforce_441_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		double ownMoney = scan.nextDouble();
		double price;
		int nSuitable=0;
		int result[] = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = 0;
			int nGood = scan.nextInt();
			for (int j = 0; j < nGood; j++) {
				price = scan.nextDouble();
				if (price < ownMoney)
				{
					if (result[i] == 0)nSuitable++;
					result[i] = 1;
				}
			}
		}
		
		System.out.println(nSuitable);
		for (int i = 0; i < n; i++) {
			if (result[i] == 1)
				System.out.print(i + 1 + " ");
		}
		scan.close();
	}
}
