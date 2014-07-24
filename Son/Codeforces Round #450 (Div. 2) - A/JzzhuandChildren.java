import java.util.Scanner;

public class JzzhuandChildren {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int n; //n=100
		int m; // m=100
		n=input.nextInt();
		m=input.nextInt();
		int [] a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=input.nextInt();
		}
		int result,tmp,max;
		result=0;
		for(int i=0;i<n;i++)
		{
			if (a[i]%m>0)
				a[i]=(a[i]/m)+1;
			else
				a[i]=a[i]/m;
			if (a[i]>=a[result])
				result=i;
		}
		
		System.out.println(Integer.toString(result+1));
		
	}

}
