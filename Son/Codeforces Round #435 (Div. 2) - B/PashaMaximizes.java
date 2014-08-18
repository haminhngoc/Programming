package olympic;
import java.util.*;

public class PashaMaximizes {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String strInput= input.nextLine();
		String [] arr= strInput.split(" ");
		char[] stringArr=arr[0].toCharArray();
		int k;//k=100
		k=Integer.parseInt(arr[1]);
		int n=stringArr.length;
		int []a=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=Integer.parseInt(Character.toString(stringArr[i]));
		}
		for(int i=0;i<n;i++)
		{
			int tmp=i;
			int num=k+i;
			if(num>=n)
				num=n-1;
			for(int j=i+1;j<=num;j++)
			{
				if(a[j]>a[tmp])
					tmp=j;
			}
			k=k-tmp+i;
			//System.out.println(k);
			int tmp2=a[tmp];
			for(int j=tmp;j>i;j--)
				a[j]=a[j-1];
			a[i]=tmp2;
		}
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]);
		}

	}

}
