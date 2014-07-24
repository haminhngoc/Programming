import java.util.Scanner;

public class Codeforce_447_D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		int col = scan.nextInt();
		int p = scan.nextInt();
		int k = scan.nextInt();

		int arrRow[] = new int[row];
		int arrCol[] = new int[col];
		for (int i = 0; i < row; i++)
			arrRow[i] = 0;
		for (int j = 0; j < col; j++)
			arrCol[j] = 0;

		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				int x = scan.nextInt();
				arrRow[i] += x;
				arrCol[j] += x;
			}
		
		int result=0;
while(k>0)
{
		int imaxRow=findMax(arrRow,row), imaxCol=findMax(arrCol, col);
		if(arrRow[imaxRow]>arrCol[imaxCol])
		{
			result+=arrRow[imaxRow];
			arrRow[imaxRow]-=row*p;
			for(int i=0; i<col; i++)arrCol[i]-=p;
		}
		else
		{
			result+=arrCol[imaxCol];
			arrRow[imaxCol]-=col*p;
			for(int i=0; i<row; i++)arrRow[i]-=p;
		}
		k--;
}	

		scan.close();
	}

	private static int findMax(int[] arr, int n) {
		// TODO Auto-generated method stub
		int imax=0;
		for(int i=0; i<n; i++)if(arr[imax]<arr[i])imax=i;
		return imax;
	}

}
