package olympic;
import java.util.*;

public class StartUp {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String strInput= input.nextLine();
		char[] a=strInput.toCharArray();
		int n=a.length;
		int []check={1,0,0,0,0,0,0,1,1,0,0,0,1,0,1,0,0,0,0,1,1,1,1,1,1,0};
		int i=0;
		int j=n-1;
		int tmp=0;
		while(i<=j)
		{
			if(a[i]==a[j])
			{
				int index=(int)a[i]-(int)'A';
				if(check[index]==0)
				{
					tmp=1;
					i=n;
					System.out.println("NO");
				}
			}
			else
			{
				tmp=1;
				i=n;
				System.out.println("NO");
			}
			i++;
			j--;
		}
		if(tmp==0)
			System.out.println("YES");
		
	}

}
