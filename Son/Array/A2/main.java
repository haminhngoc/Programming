package array;
import java.util.*;

public class A2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int []a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=input.nextInt();
		int count=0;
		int max=0,first=-1,end=-1;
		for(int i=0;i<n;i++)
		{
			if(a[i]>=0)
			{
				count++;
				if(count>max)
				{
					max=count;
					end=i;
				}
			}
			else
				count=0;
		}
		if(end>-1)
			first=end+1-max;
		System.out.println("eleents: "+max);	
		System.out.println("first: "+first);
		System.out.println("end: "+end);
	}

}
