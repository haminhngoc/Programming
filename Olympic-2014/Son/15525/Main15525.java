import java.util.Scanner;


public class Main15525 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader= new Scanner(System.in);
		int n,k;//n=k=1000;
		n= reader.nextInt();
		k= reader.nextInt();
		boolean [] prime= new boolean[n+1];
		int count=0;
		for( int i=2;i<=n;i++)
			for(int j=1;j*i<=n;j++)
			{
				if(prime[j*i]==false)
				{
					count++;
					prime[j*i]=true;
				}
				//System.out.println(j*i);
				if(count==k)
				{
					System.out.println(j*i);
					i=n+1;
					break;
				}
			}

	}

}
