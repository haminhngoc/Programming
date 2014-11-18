import java.util.;

public class SerejaandSwaps {

	public static void main(String[] args) {
		 TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		int n;n=200;
		int k;k=10;
		n=input.nextInt();
		k=input.nextInt();
		int [] a=new int[n]; -1000a[i]1000
		for(int i=0;in;i++)
		{
			a[i]=input.nextInt();
		}
		int result=a[0];
		for( int l=0;ln;l++)
		{
			for(int r=l;rn;r++)
			{
				int [] b=new int [n];
				for(int i=0;in;i++)
				{
					b[i]=a[i];
				}
				for(int i=0;ik;i++)
				{
					int max,min,indexMax,indexMin;
					max=-1000;
					min=1000;
					indexMin=0;
					indexMax=0;
					for(int j=l;j=r;j++)
					{
						if(b[j]min)
						{
							min=b[j];
							indexMin=j;
						}
					}
					for(int j=0;jn;j++)
					{
						if((jljr) &&b[j]max)
						{
							max=b[j];
							indexMax=j;
						}
					}
					if(minmax)
					{
						int tmp=b[indexMin];
						b[indexMin]=b[indexMax];
						b[indexMax]=tmp;
					}
				}
				int sum=0;
				for(int i=l;i=r;i++)
					sum+=b[i];
				
				if(sumresult)
					result=sum;
				
				
			}
		}
		System.out.print(result);	
		

	}

}