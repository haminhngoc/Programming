package olympic;
import java.util.*;

public class LittlePonyandCrystalMine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int n;//n=101,n is odd;
		n=input.nextInt();
		int [][]matrix= new int[n][n];
		int mid=n/2;
		for(int i=0;i<n;i++)
			matrix[mid][i]=1;
		int tmp=0;
		for(int i=mid;i>=0;i--)
		{
			for(int j=tmp;j<n-tmp;j++)
				matrix[i][j]=1;
			tmp++;
		}
		tmp=1;
		for(int i=mid+1;i<n;i++)
		{
			for(int j=tmp;j<n-tmp;j++)
				matrix[i][j]=1;
			tmp++;
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(matrix[i][j]==1)
					System.out.print("D");
				else
					System.out.print("*");
			}
			System.out.println();
		}
			
			

	}

}
