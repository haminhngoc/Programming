import java.util.Scanner;

public class Mian2250 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int n, p;// n=50000,p=10^9
		n = reader.nextInt();
		p = reader.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = reader.nextInt();

		for (int i = 1; i < n; i++)
			a[i] += a[i - 1];
		int count=-1;
		int max=-1;
		for(int l=0;l<n-1;l++)
		{
			for(int r=l+1;r<n;r++)
			{
				if(a[r]-a[l]>=p)
					count=r-l;
				if(count>max)
					max=count;
				
			}
		}
		System.out.println(max);

	}

}
