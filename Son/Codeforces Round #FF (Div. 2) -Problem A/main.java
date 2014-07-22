import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String strInput;
		strInput =input.nextLine();
		String []inputArr=strInput.split(" ");
		int p,n;
		p=Integer.parseInt(inputArr[0]);
		n=Integer.parseInt(inputArr[1]);
		int []narr=new int[n];
		for(int i=0;i<n;i++)
		{
			strInput=input.nextLine();
			narr[i]=Integer.parseInt(strInput);
		}
		
		int [] pArr=new int[p];
		for(int i=0;i<p;i++)
		{
			pArr[i]=0;
			
		}
		int result=-1;
		
		for(int i=0;i<n;i++)
		{
			int tmp=narr[i]%p;
			if(pArr[tmp]==0)
			{
				pArr[tmp]=1;
				
			}
			else
			{
				result=i+1;
				i=n;
			}
		}
		System.out.println(Integer.toString(result));
		}
	}
