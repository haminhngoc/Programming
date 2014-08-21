import java.util.Scanner;

public class A5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		int max = 0, l = 0, r = 0, imin=0, imax=0;
		for (int i = 1; i < n ; i++)
			{
				if(a[i]>a[r]) r=i;
				if(a[i]<a[l])
				{
					if(a[r]-a[l]>max)
					{
						imin=l;
						imax=r;
						max=a[r]-a[l];
					}
					l=i;
					r=i;
				}
			}
		if(a[r]-a[l]>max)
		{
			imin=l;
			imax=r;
		}
		System.out.println(imin + " " + imax);
		scan.close();
	}

}
