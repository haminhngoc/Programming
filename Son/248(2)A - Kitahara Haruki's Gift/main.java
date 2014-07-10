import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String strInput;
		strInput =input.nextLine();
		int num=Integer.parseInt(strInput);
		String strInput2;
		strInput2=input.nextLine();
		String[] strArr=strInput2.split(" ");
		int result=0;
		int [] arr=new int[strArr.length];
		for(int i=0;i<strArr.length;i++)
		{
			arr[i]=Integer.parseInt(strArr[i]);
			result=result+arr[i];
		}
		if(num%2==0 && result/100%2==0)
			System.out.print("YES");
		else if(num%2==0 && result/100%2==1)
			System.out.print("NO");
		else
		{
			int temp;
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j <= i; j++) {
		           if(arr[j] < arr[i]) 
		           {
		               temp = arr[i];
		               arr[i] = arr[j];
		               arr[j] = temp;
		           }
				}
			}
			temp=0;
			for(int i=0;i<arr.length;i++)
			{
				if(temp<(result/2))
					temp+=arr[i];
			}
			if(temp==result/2)
				System.out.print("YES");
			else if(temp-arr[num-1]==result/2)
				System.out.print("YES");
			else
				System.out.print("NO");
		}
	}

}