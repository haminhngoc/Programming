import java.util.Scanner;


public class DZYLOVEHASH {
	private static Scanner readers = new Scanner(System.in);
	public static void main(String[] args) {
		int p,n,i;
		int [] array;
		int [] result;
		p= readers.nextInt();
		n=readers.nextInt();
		array = new int [n];
		result= new int [p];
		for(i=0;i<n;i++)
		{
			array[i]= readers.nextInt();
		}
		for(i=0;i<p;i++)
		{
			result[i]=-1;
		}
		for(i=0;i<n;i++)
		{
			int mod= array[i] % p;
			if(result[mod]!=-1) 
			{
				System.out.print(i+1);
				break;
			}
			else result[mod]=mod;
		}
		if(i==n)System.out.print(-1);
	}
}
