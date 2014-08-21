import java.util.Scanner;

public class LittlePonyAndCrystalMine {
	private static Scanner readers = new Scanner(System.in);

	public static void main(String[] args) {
		int n,midle;
		n = readers.nextInt();
		midle = n/2;
		char[][] array = new char[n][n];
		int count = -1;
		for (int i = 0; i < n; i++) {
			if (i <= midle)
				count += 2;
			else count-=2;
			for (int j = 0; j < n; j++) {
				if (j <= midle - (count+1)/2 || j >= midle + (count+1)/2)
					array[i][j] = '*';
				else
					array[i][j] = 'D';
			}
		}
		for(int i=0;i<n;i++)
		{
			String temp = new String(array[i]);
			System.out.print(temp+"\n");
		}

	}

}
