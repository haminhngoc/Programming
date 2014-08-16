package olympic;
import java.util.*;
public class ShowerLine {

	//static int [][]g= new int[5][5];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int [][]g= new int[5][5];
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
				g[i][j]=input.nextInt();
		}
		int result=0;
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				if(j==i)
					continue;
				for(int k=0;k<5;k++)
				{
					if(k==j || k==i)
						continue;
					for(int p=0;p<5;p++)
					{
						if(p==k||p==i||p==j)
							continue;
						for(int q=0;q<5;q++)
						{
							if(q==i||q==j||q==k||q==p)
								continue;
							int tmp=0;
							tmp=g[i][j]+g[j][i]+g[k][p]+g[p][k]+g[j][k]+g[k][j]+g[p][q]+g[q][p]+g[k][p]+g[p][k]+g[p][q]+g[q][p];
							if(tmp>result)
								result=tmp;
						}
					}
				}
			}
		}
		
		System.out.println(Integer.toString(result));

	}

}
