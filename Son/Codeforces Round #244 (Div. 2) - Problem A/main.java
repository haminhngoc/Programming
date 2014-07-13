import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String strnum;
		Scanner input = new Scanner(System.in);
        	strnum = input.nextLine();
       		int num=Integer.parseInt(strnum);
        	String strinfo=input.nextLine();
        	String[] tmpStr = strinfo.split(" ");
        	int[] arr = new int[num];
        	int result=0;
        	for (int i = 0; i < num; i++)
        	{
        		arr[i] = Integer.parseInt(tmpStr[i]);
        	}
        	int tmp=0;
        	for (int i = 0; i < num; i++)
        	{
        		if(tmp==0 && arr[i]<0)
        			result=result+1;
        		if(tmp>0 && arr[i]<0)
        			tmp=tmp-1;
        		if(arr[i]>0)
        			tmp=tmp+arr[i];
        	}
        
        	System.out.print(Integer.toString(result));
		}

}
