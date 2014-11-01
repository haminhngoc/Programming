import java.util.*;

public class SorttheArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		int n;//n=10^5;
		n=input.nextInt();
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=input.nextInt();
		int tmp=0;
		for(int i=0;i<n-1;i++)
			if(a[i]>a[i+1])
			{
				tmp=1;
				break;
			}
		if(tmp==0)
		{
			System.out.println("yes");
			System.out.println("1 1");
			
		}
		else
		{
			int index1,index2;
			index1=index2=-1;
			for(int i=1;i<n;i++)
			{
				if(a[i-1]>a[i] && index1==-1)
					index1=i-1;
				if(a[i-1]<a[i]&& index1!=-1)
				{
					index2=i-1;
					break;
							
				}
				else if(i==n-1 && a[i-1]>a[i])
					index2=n-1;
					
			}
			
			if(index1==0&& index2==n-1)
			{
					System.out.println("yes");
					System.out.println(Integer.toString(index1+1));
					System.out.println(Integer.toString(index2+1));
					
			}
			else if(index1!=0&& index2<n-1)
			{
				if(a[index1]>a[index2+1]||a[index2]<a[index1-1])
					System.out.println("no");
				else
				{
					int tmp2=0;
					for(int i=index2+1;i<n-1;i++)
						if(a[i]>a[i+1])
						{
							tmp2=1;
							break;
						}
					if(tmp2==1)
						System.out.println("no");
					else
					{
						System.out.println("yes");
						System.out.println(Integer.toString(index1+1));
						System.out.println(Integer.toString(index2+1));
					}
							
				}
			}
			else if(index1==0&& index2<n-1)
			{
				if(a[index1]>a[index2+1])
					System.out.println("no");
				else
				{
					int tmp2=0;
					for(int i=index2+1;i<n-1;i++)
						if(a[i]>a[i+1])
						{
							tmp2=1;
							break;
						}
					if(tmp2==1)
						System.out.println("no");
					else
					{
						System.out.println("yes");
						System.out.println(Integer.toString(index1+1));
						System.out.println(Integer.toString(index2+1));
					}
							
				}
			}
			else if(index2==n-1 && index1!=0)
			{
				if(a[index2]<a[index1-1])
					System.out.println("no");
				else
				{
					int tmp2=0;
					for(int i=index2+1;i<n-1;i++)
						if(a[i]>a[i+1])
						{
							tmp2=1;
							break;
						}
					if(tmp2==1)
						System.out.println("no");
					else
					{
						System.out.println("yes");
						System.out.println(Integer.toString(index1+1));
						System.out.println(Integer.toString(index2+1));
					}
							
				}
			}
			//System.out.println(Integer.toString(index1));
			//System.out.println(Integer.toString(index2));
			
			
		}
		
	}

}