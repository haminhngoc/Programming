package array;
import java.util.*;

public class A1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int []a=new int [n];
		int max=1;
		int count=1;
		for(int i=0;i<n;i++)
			a[i]=input.nextInt();
		int first=0,end=0;
		for(int i=1;i<n;i++)
		{
			if(a[i]>=a[i-1])
			{
				count++;
				if(count >max)
				{
					max=count;
					end=i;
				}
			}
			else
			count=1;	
		}
		
		System.out.println("elemens: "+ max);
		System.out.println("first: "+(end+1-max));
		System.out.println("end: "+end);

	}

}
