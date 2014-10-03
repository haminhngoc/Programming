package array;
import java.util.*;

public class A8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int []a=new int[n];
		int k=input.nextInt();
		for(int i=0;i<n;i++)
			a[i]=input.nextInt();
		int min=100000, max=-100000,end=0,count=0,sum=0,index=0;
		for(int i=0;i<n;i++)
		{
			count++;
			if(a[i]>max){
				max=a[i];
				index=i;
			}
			if(a[i]<min)
				min=a[i];
			if(max-min<=k){
				if(count>sum){
					sum=count;
					end=i;
				}
			}
			
			if(max-min>k){
				count=0;
				max=-100000;
				min=100000;
				i=index+1;
				
			}
			//System.out.println(max+" "+min+" "+sum);
		}
		System.out.println("elemens: "+ sum);
		System.out.println("first: "+(end+1-sum));
		System.out.println("end: "+end);
		
	}

}
