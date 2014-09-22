package array;
import java.util.*;

public class A6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int []a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=input.nextInt();
		int sum=0,max=a[0];
		for(int i=0;i<n;i++)
		{
			sum +=a[i];
			if(sum>max)
				max=sum;
			if(sum<0)
				sum=0;
		}
		System.out.println(max);
		

	}

}
