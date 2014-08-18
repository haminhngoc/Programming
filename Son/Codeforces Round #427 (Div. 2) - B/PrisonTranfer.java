package olympic;

import java.util.Scanner;

public class PrisonTranfer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		int n;// n=2*10^5
		int t;//t=10^9
		int c;//c=n
		n=input.nextInt();
		t=input.nextInt();
		c=input.nextInt();
		int []a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=input.nextInt();
		int result=0;
		int tmp=0;
		for(int i=0;i<n;i++)
		{
			if(a[i]>t)
			{
				if(tmp>=c)
					result=result+tmp-c+1;
				tmp=0;
			}
			else
				tmp++;
			
		}
		if(tmp>=c)
			result=result+tmp-c+1;
		System.out.println(Integer.toString(result));
	}

}

