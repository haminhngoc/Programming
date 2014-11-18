import java.util.Scanner;

public class SuffixStructures {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String s=input.nextLine();
		String t=input.nextLine();
		char[] arrS;
		char[] arrT;
		arrS=s.toCharArray();
		arrT=t.toCharArray();
		int numS=arrS.length;
		int numT=arrT.length;
		int tmp1=0;
		int [] arr=new int[numS];
		for(int i=0;i<numS;i++)
			arr[i]=0;
		for(int i=0;i<numT;i++)
		{
			int tmp=0;
			for(int j=0;j<numS;j++)
			{
				if(arrT[i]==arrS[j] && arr[j]==0)
				{
					tmp=1;
					arr[j]=1;
					break;
				}
			}
			if(tmp==0)
			{
				tmp1=1;
				//System.out.print(Integer.toString(i));
			}
		}
		if(tmp1==1||numT>numS)
			System.out.println("need tree");
		else
		{
		int tmp=0;
		for(int i=0;i<numT;i++)
		{
			int tmp2=0;
			for(int j=tmp;j<numS;j++)
			{
				if(arrT[i]==arrS[j])
				{
					tmp=j+1;
					tmp2=1;
					break;
				}
			}
			if(tmp2==0)
			{
				//System.out.println(Integer.toString(i)+" "+Integer.toString(tmp-1));
				tmp1=2;
				break;
			}
		}
		if(tmp1==2 && numT!=numS)
			System.out.println("both");
		else if(numT==numS)
			System.out.println("array");
		else if(tmp1!=2 && numT!=numS)
			System.out.println("automaton");
		}
		

	}

}