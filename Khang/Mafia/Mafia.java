import java.util.Arrays;
import java.util.Scanner;

public class Mafia {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {

		int nPlayer = reader.nextInt();
		int[] playerRounds = new int[nPlayer];
		for (int i = 0; i < nPlayer; i++) {
			playerRounds[i] = reader.nextInt();
		}
		Arrays.sort(playerRounds);
		boolean otherPlayerFinished = false;
		int minimumRound = 0;
		while (otherPlayerFinished)
		{
			otherPlayerFinished = DecreaseRounds(playerRounds);
			minimumRound++;
		}
		minimumRound += playerRounds[0] - 1; 
		System.out.println(minimumRound);
		
	}
	public static boolean DecreaseRounds(int [] playerRounds)
	{
		int index = playerRounds.length;
		int countPlayer = 0;
		while (index > 0)
		{
			if (playerRounds[index] > 0)
				playerRounds[index]--;
			else
				countPlayer++;
			index--;
		}
		if (countPlayer == playerRounds.length - 1)
		{
			return true;
		}
		return false;
	}

}
