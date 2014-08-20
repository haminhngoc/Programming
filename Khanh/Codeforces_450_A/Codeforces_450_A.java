import java.util.Scanner;


public class Codeforces_450_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int m=scan.nextInt();
		int [] a=new int[n];
		int iLast=0;
		for (int i=0; i<n; i++)
			{
			a[i]=scan.nextInt();
			if (a[i]%m>0)a[i]=(a[i]/m)*m+m;
			if (a[i]>=a[iLast])
				{
				iLast=i;
				}
			}
		System.out.print(iLast+1);
		
		scan.close();
	}

}
