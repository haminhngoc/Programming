package array;
import java.util.*;

public class A7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int []a=new int[n];
		int k1,k2;
		k1=input.nextInt();
		k2=input.nextInt();
		for(int i=0;i<n;i++)
			a[i]=input.nextInt();
		int count=0,max=a[0],sum=0,tmp=0,end=-1;
		for(int i=0;i<n;i++)
		{
			if(a[i]<=k2){
				count++;
				if(a[i]>max)
					max=a[i];
			}
			
			if(count>sum && max>=k1){
				sum=count;
				end=i;
			}
			
			if(a[i]>k2){
				count=0;
				max=0;
			}
		}
		
		if(sum==0)
			System.out.print("no sub array");
		else
		{
			System.out.println("elements: "+sum);
			System.out.println("first: "+(end+1-sum));
			System.out.println("end: "+end);
			//System.out.print(k1+"   "+k2);
		}
	}

}
