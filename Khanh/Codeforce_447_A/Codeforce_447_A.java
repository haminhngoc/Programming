import java.util.Scanner;


public class Codeforce_447_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int nBuckets=scan.nextInt(), nNumbers=scan.nextInt();
		int arrFilledBuckets[]=new int[nBuckets];
		int nFBuckets=0, result=-1;
		for (int i=0; i<nNumbers;i++)
		{
			int x=scan.nextInt();
			x=x%nBuckets;
			//System.out.println(x);
			if ((nFBuckets==0)||(search(x,arrFilledBuckets,nFBuckets)==false))
			{
				arrFilledBuckets[nFBuckets]=x;
				nFBuckets++;			
			}
			else
			{
				if(result==-1)result=i+1;
			}
		}
		System.out.println(result);
		scan.close();
	}

	private static boolean search(int i, int[] arrFilledBuckets, int nFBuckets) {
		// TODO Auto-generated method stub
		for(int j=0; j<nFBuckets; j++)if(i==arrFilledBuckets[j])return true;
		return false;
	}

}
