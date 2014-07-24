
import java.util.Scanner;
public class PashaandHamsters {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String strInput=input.nextLine();
		String [] arr=strInput.split(" ");
		int n=Integer.parseInt(arr[0]); // n=100;
		int a=Integer.parseInt(arr[1]); //a=100;
		int b=Integer.parseInt(arr[2]); //b=100
		int []arrN= new int [n];
		int []arrA=new int [a];
		strInput=input.nextLine();
		arr=strInput.split(" ");
		for(int i=0;i<a;i++)
		{
			arrN[Integer.parseInt(arr[i])-1]=1;
		}
		for(int i=0;i<n;i++)
		{
			if(arrN[i]==1)
				System.out.println("1");
			else
				System.out.println("2");
			
		}
	}

}
