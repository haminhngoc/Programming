import java.util.*;

public class LittlePonyandSortbyShift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		int n;//n=10^5;
		n=input.nextInt();
		int [] a= new int[n];
		for(int i=0;i<n;i++)
			a[i]=input.nextInt();
		int first=a[0];
		int tmp=0;
		int count=0;
		for(int i=n-1;i>=0;i--)
		{
			if(a[i]<=first)
			{
				//tmp=first;
				first=a[i];
				//a[i]=tmp;
				count++;
				
			}
			else
				break;
		}
		int tmp2=0;
		first=a[0];
		for(int i=1;i<n;i++)
		{
			if(a[i]<a[i-1]&& a[i]>first)
			{
				tmp=1;
				break;
			}
			
			if(a[i]!=a[i-1])
				tmp2=1;
		}
		int tmp3=0;
		int tmp1=0;
		for(int i=1;i<n;i++)
		{
			if(a[i]<a[i-1] && tmp1==0)
			{
				tmp1=1;
			}
			else if(a[i]<a[i-1] && tmp1==1)
			{
				tmp3=1;
				break;
			}
			
		}
		int tmpp=0;
		for(int i=1;i<n;i++)
			if(a[i]<a[i-1])
			{
				tmpp=1;
				break;
			}
		if(tmp3==1 || tmp==1)
			System.out.println("-1");
		else if(tmpp==1 && count==0)
			System.out.println("-1");
		else if(tmp2==0 && tmp==0)
			System.out.println("0");
		else if(tmp2==1 && tmp==0)
			System.out.println(count);
		
			
	
	}

}