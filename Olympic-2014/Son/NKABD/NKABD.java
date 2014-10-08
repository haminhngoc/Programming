import java.util.Scanner;


public class NKABD {

	public static void main(String[] args) {
		Scanner reader= new Scanner(System.in);
		int L,R;//L=R=10^5;
		L=reader.nextInt();
		R=reader.nextInt();
		int n=100001;
		boolean[] prime= new boolean[100002];
		prime[0] = true;
		prime[1] = true;
		for (int i = 2; i <= n/2; i++)
			for (int j = 2; j * i <=n; j++) {
				prime[i * j] = true;
			}
		
		int count=0;
		for(int i=0;i<n;i++)
			if(prime[i]==false)
				count++;
		System.out.println(count);
		
		boolean [] num= new boolean[n];
		/*for(int i=0;i<n;i++)
		{
			if(prime[i]==true)
			{
				int sum=0;
				for(int j=1;j<i/2;j++)
				{
					if(i%j==0)
						sum+=j;
					if(sum>i)
						break;
				}
				if(sum>i)
					num[i]=true;
			}
		}*/
		int result=0;
		for(int i=L;i<=R;i++)
			if(num[i]==true)
				result++;
		System.out.println(result);
			
	}

}
