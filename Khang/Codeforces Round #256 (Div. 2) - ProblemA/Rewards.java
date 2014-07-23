import java.util.*;

public class Rewards {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int totalCup = 0, totalMedal = 0; // 100		
		for (int i = 0; i < 3; i++) {
			totalCup += reader.nextInt();
		}
		for (int i = 0; i < 3; i++) {
			totalMedal += reader.nextInt();
		}
		int nShelf = reader.nextInt(); // 100
		int totalCupShelf = ((totalCup % 5 > 0) ? 1 : 0) + totalCup / 5;
		int totalMedalShelf = ((totalMedal % 10 > 0) ? 1 : 0) + totalMedal / 10;
		if (totalCupShelf + totalMedalShelf <= nShelf)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
