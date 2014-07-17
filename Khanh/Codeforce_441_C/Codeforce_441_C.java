import java.util.Scanner;

public class Codeforce_441_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt(), k = scan.nextInt();
		if (2*k > n * m)
			System.out.println("the number of tubes is not suitable");
		else
			printTubes(m, n, k);
		scan.close();
	}

	private static void printTubes(int m, int n, int k) {
		// TODO Auto-generated method stub
int rCells=(m*n)%k;
	int xCell=0, yCell=1;
	int nCells=m*n/k;
	while (k>0)
	{
		int nTubes=nCells;
		if(rCells>0)
		{
			rCells--;
			nTubes++;
		}
		int step=1;
		System.out.println(nTubes);

		while (nTubes>0)
		{
			if (((xCell==m)&(step==1))||(xCell==1)&(step==-1))
			{
				yCell++;
				step=step*(-1);
			}
			xCell+=step;
			printCell(xCell,yCell);			
		}
		k--;
	}

	}

	private static void printCell(int xCell, int yCell) {
		// TODO Auto-generated method stub
		System.out.print(xCell+" "+yCell+" ");
	}

}
