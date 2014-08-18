package olympic;
import java.util.*;

public class SerejaandMirroring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int n,m;//n=m=100
		n=input.nextInt();
		m=input.nextInt();
		int [][] a=new int[n][m];
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
				a[i][j]=input.nextInt();
				
		int tmp=n;
		int tmp2=0;
		while(tmp%2==0 && tmp2==0)
		{
			int i,j;
			i=0;j=tmp-1;
			while(i<j)
			{
				for(int k=0;k<m;k++)
				{
					if(a[i][k]!=a[j][k])
					{
						tmp2=1;
						i=j;
						break;
					}
					//System.out.println(Integer.toString(a[i][k])+" "+Integer.toString(a[j][k]));
				}
					i++;j--;
			}
			if(tmp2==0)
				tmp=tmp/2;
			
		}
		System.out.println(Integer.toString(tmp));
	}

}
