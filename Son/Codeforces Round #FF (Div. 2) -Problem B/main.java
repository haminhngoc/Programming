import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String strInput;
		strInput =input.nextLine();
		//
		char[] stringArray;
		stringArray=strInput.toCharArray();
		int n=strInput.length();
		int k;
		strInput=input.nextLine();
		k=Integer.parseInt(strInput);
		strInput=input.nextLine();
		String []inputArr=strInput.split(" ");
		int [] nArr=new int[26];
		int max=0;
		for(int i=0;i<26;i++)
		{
			nArr[i]=Integer.parseInt(inputArr[i]);
			if(nArr[i]>max)
				max=nArr[i];
		}
		
		
		int result=0;
		for(int i=0;i<n;i++)
		{
			int tmp=0;
			tmp=(int)stringArray[i];
			tmp=tmp-97;
			result=result+((i+1)*nArr[tmp]);
			//System.out.println(Integer.toString(result)+"n");
		}
		for(int i=n+1;i<=(n+k);i++)
		{
			result=result+(i*max);
			//System.out.println(Integer.toString(result)+"k");
		}
		
		System.out.println(Integer.toString(result));
		
	}

}