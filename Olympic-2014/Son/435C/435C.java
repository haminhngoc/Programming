import java.util.*;

public class Cardiogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		int n;//n=1000
		n=input.nextInt();
		int max=0;
		int min=0;
		int []a= new int[n];
		int index=0;
		int column=0;
		int tmp=1;
		int sum=0;
		for(int i=0;i<n;i++)
		{
			a[i]=input.nextInt();
			column+=a[i];
			sum+=a[i]*tmp;
			if(max<sum)
			{
				max=sum;
				index=i;
			}
			if(min>sum)
				min=sum;
			tmp=tmp*-1;
		}
		max=max-min;
		if(index%2==1)
			index=index-1;
		int start=0;
		for(int i=0;i<=index;i++)
		{
			if(i%2==0)
				start=start+a[i];
			else
				start=start-a[i];
		}
		int j=start;
		char [][]matrix=new char[max][column];
		for (int i = 0; i< max; i++) 
			for(int k=0;k<column;k++)
				matrix[i][k]=' ';
		int count=0;
		for(int i=0;i<n;i++)
		{
			for(int k=0;k<a[i];k++)
			{
				if(i%2==0)
				{
					j--;
					matrix[j][count]='/';
					//System.out.println(j);
					
				}
				else
				{
					j++;
					matrix[j][count]='\\';
					//System.out.println(j);
					
				}
				count++;
			}
			if(i%2==0)
				j--;
			else
				j++;
		}
		for (int i = 0; i< max; i++) 
		{
			String output="";
			for(int k=0;k<column;k++)
			{
				output+=matrix[i][k];
			}
			System.out.println(output);
			
		}

	}

}