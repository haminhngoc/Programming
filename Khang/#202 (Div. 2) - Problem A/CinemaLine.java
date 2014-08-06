import java.util.Scanner;

public class CinemaLine {

private static Scanner reader = new Scanner(System.in);
	
	public static void main(String[] args) {
		int nPeople = 0;
		nPeople = reader.nextInt();
		if (nPeople > 0 && nPeople <= Math.pow(10, 5)) {
			int[] values = new int[nPeople];
			for (int i = 0; i < nPeople; i++) {
				values[i] = reader.nextInt();
			}
			if (CanSell(nPeople, values))
				System.out.println("YES");
			else
				System.out.println("NO");
		} else
			System.out.println("NO");

	}
	
	private static boolean CanSell(int nPeople, int[] values) {
		int[] nCurrency = new int[] { 0, 0, 0 };
		for (int i = 0; i < nPeople; i++) {
			switch (values[i]) {
			case 25:
				nCurrency[0] += 1;
				break;
			case 50:
				if (nCurrency[0] > 0)
				{
					nCurrency[0]--;
					nCurrency[1]++;
				}
				else
					return false;
				break;
			case 100:
				if (nCurrency[1] > 0 && nCurrency[0] > 0) {
					nCurrency[0]--;
					nCurrency[1]--;					
				}
				else if (nCurrency[0] > 2)
				{
					nCurrency[0] -=3;					
				}
				else
					return false;
				break;
			}
		}
		return true;
	}
}
