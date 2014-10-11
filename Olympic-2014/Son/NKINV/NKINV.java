import java.util.Random;
import java.util.Scanner;


public class NKINV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader= new Scanner(System.in);
		Random rd=new Random();
		int n;//n=60000;
		n=reader.nextInt();
		int [] a= new int[n];
		int []index= new int[60001];
		for(int i=0;i<n;i++)
			index[i]=-1;
		String []same= new String[60001];
		for(int i=0;i<60001;i++)
		{
			a[i]=reader.nextInt();
			if(index[a[i]-1]==-1)
				index[a[i]-1]=i;
			else
			{
				if(same[i]==null)
					same[a[i]-1]=Integer.toString(i)+" ";	
				else
					same[a[i]-1]+=Integer.toString(i)+" ";	
			}
		}
		String result="";
		for(int i=0;i<n;i++)
		{
			if(index[i]!=-1)
				result+=Integer.toString(index[i])+" ";
			if(same[i]!=null)
				result+=same[i];
			//System.out.println(same[i]);
		}
			
		/*for(int i=0;i<n;i++)
			System.out.print(index[i]+" ");
		System.out.print("\n");
		for(int i=0;i<n;i++)
			System.out.print(same[i]+ " ");*/
		System.out.println(result);
		
			

	}

}
