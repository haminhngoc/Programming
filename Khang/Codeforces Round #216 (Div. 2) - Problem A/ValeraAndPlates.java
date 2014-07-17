
import java.util.Scanner;

public class ValeraAndPlates {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {	
		int nDay = 0, nCleanBowl = 0, nCleanPlate = 0;
		nDay = reader.nextInt();
		nCleanBowl = reader.nextInt();
		nCleanPlate = reader.nextInt();
		int nWash = 0;
		int[] days = new int[nDay];
		for (int i = 0; i < nDay; i++) {
			days[i] = reader.nextInt();
		}
		for (int i = 0; i < nDay; i++) {
			if (days[i] == 1) {
				if (nCleanBowl > 0) {
					nCleanBowl--;
				} else {
					nWash++;
				}
			} else {
				if (nCleanPlate > 0) {
					nCleanPlate--;
				} else if (nCleanBowl > 0) {
					nCleanBowl--;
				} else {
					nWash++;
				}
			}
		}
		System.out.println(nWash);
	}
}
