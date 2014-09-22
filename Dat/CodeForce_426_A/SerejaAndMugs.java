
import java.util.Arrays;
import java.util.Scanner;


public class SerejaAndMugs {
private static Scanner readers = new Scanner(System.in);
	public static void main(String[] args) {
		int n,s;
		n=readers.nextInt();
		s=readers.nextInt();
		int []array= new int [n];
		for(int i=0;i<n;i++)
		{
			array[i]=readers.nextInt();
		}
		Arrays.sort(array);
		int total=0;
		for(int i=0;i<n-1;i++)
		{
			total+=array[i];
		}
		if(total>s) System.out.print("NO");
		else System.out.print("YES");

	}

}
