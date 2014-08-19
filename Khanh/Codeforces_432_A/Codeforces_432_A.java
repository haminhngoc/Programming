import java.util.Scanner;


public class Codeforces_432_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt(), k=scan.nextInt();
		int freemen=0;
		for(int i=0; i<n; i++)		
		{
			int x=scan.nextInt();
			if (x+k<=5)freemen++;
		}
		System.out.println(freemen/3);
		scan.close();
	}

}
