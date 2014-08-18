import java.util.*;


public class PredictOutComeOfTheGame {
private static Scanner readers = new Scanner(System.in);
	public static void main(String[] args) {
		int n;
		n=readers.nextInt();
		int [][] array = new int [n][4];
		for(int i=0;i<n;i++)
		{
			array[i][0]=readers.nextInt();
			array[i][1]=readers.nextInt();
			array[i][2]=readers.nextInt();
			array[i][3]=readers.nextInt();
		}
		boolean team1GeaterTeam3;
		for(int i=0;i<n;i++)
		{
			if(array[i][2]==0 && array[i][3]==0) System.out.print("no");
			else
			{
				if(array[2]-array[3]>0 )
			}
		}

	}

}
