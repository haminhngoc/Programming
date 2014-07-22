import java.util.Scanner;

public class QueueonBusStop {

	public static void main(String[] args) {
	Scanner input=new Scanner(System.in);
	String strInput;
	strInput=input.nextLine();
	String [] arrInput=strInput.split(" ");
	int n,m; //100
	n=Integer.parseInt(arrInput[0]);
	m=Integer.parseInt(arrInput[1]);
	strInput=input.nextLine();
	arrInput=strInput.split(" ");
	int [] arr= new int[n];
	for(int i=0;i<n;i++)
	{
		arr[i]=Integer.parseInt(arrInput[i]);
	}
	int numbus=0;
	int tmp=0;
	for(int i=0;i<n;i++)
	{
		if(tmp+arr[i]<=m)
		{
			tmp=tmp+arr[i];
		}
		else
		{
			tmp=0;
			i=i-1;
			numbus=numbus+1;
			
			
		}
		//System.out.println(Integer.toString(tmp)+"  "+Integer.toString(i));
	}
	System.out.println(Integer.toString(numbus+1));

	}

}
