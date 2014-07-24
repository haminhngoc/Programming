import java.util.Scanner;


public class DZY_Loves_Chessboard {

	private static Scanner reader= new Scanner(System.in);

	public static void main(String[] args) {
		int n=0,m=0;
		n=reader.nextInt();
		m=reader.nextInt();
		String[][] a= new String[n][m];
		for(int i=0;i<n-1;i++)
		{	String temp= reader.next();
			for(int j=0;j<m;j++)
			{
				a[i][j]= temp.charAt(0)+"";
			}
		}
		for(int i=0;i<=n-1;i++)
		{
			for(int j=i%2;j<=m-1;j+=2)
			{
				if(a[i][j]!="-") a[i][j]="W";
			}
		}
		for(int i=0;i<=n-1;i++)
		{
			for(int j=i%2==0?1:0;j<=m-1;j+=2)
			{
				if(a[i][j]!="-") a[i][j]="B";
			}
		}
		for(int i=0;i<=n-1;i++)
		{	
			for(int j=0;j<=m-1;j++)
			{
				System.out.print( a[i][j] +"");
			}
			System.out.print( "   "+ m+"  \n");
		}
		System.out.print("kt");
	}
}


