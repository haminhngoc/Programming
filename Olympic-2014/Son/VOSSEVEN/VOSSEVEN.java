import java.util.Scanner;


class VOSSEVEN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader= new Scanner(System.in);
		String s=reader.next();
		s+="0";
		char[]a=s.toCharArray();
		int n=a.length;
		int[] label= new int[n];
		int count=0;
		for(int i=0;i<n;i++)
		{
			if(a[i]=='7')
			{
				count++;
			}
			else
			{
				//System.out.println(count);
				for(int j=1;j<=count;j++)
				{
					label[j]+=count-j+1;
				}
				count=0;
			}
		}
		StringBuilder result= new StringBuilder();
		for(int i=0;i<n;i++)
			if(label[i]!=0)
				result.append(i+" "+label[i]+"\n");
		System.out.println(result.toString());
		

	}

}
