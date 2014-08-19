package array;
import java.util.*;
import java.util.Vector;

public class A5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int []a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=input.nextInt();
		int first=0,end=1,tmp=0;
		int max=a[1]-a[0];
		for(int i=1;i<n;i++)
		{
			if(a[i]-a[tmp]>max)
			{
				max=a[i]-a[tmp];
				first=tmp;
				end=i;	
			}
			if(a[i]<a[tmp])
				tmp=i;
		}
		
		System.out.println("i:"+first+ " - value: "+a[first]);
		System.out.println("j:"+end+ " - value: "+a[end]);

	}

}
