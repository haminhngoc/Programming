import java.util.Scanner;

public class A7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n], k1=scan.nextInt(), k2=scan.nextInt();
		if(k1>k2){
			int t=k2; k2=k1; k1=t;
		}
		int arrk2[]=new int [n];
		boolean arrk1[]=new boolean [n];
		int nK=0;
		for (int i = 0; i < n; i++)
		{
			a[i] = scan.nextInt();
			if(a[i]>=k1)arrk1[nK]=true;
			if(a[i]>k2)arrk2[nK]=i;
			}
		int l=0, r=0;
		System.out.println(l + " " + r);
		scan.close();
}
}