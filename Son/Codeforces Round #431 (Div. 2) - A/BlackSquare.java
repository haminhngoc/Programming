import java.util.Scanner;

public class BlackSquare {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String strInput=input.nextLine();
		String []arrA= strInput.split(" ");
		int [] a=new int [4];
		for(int i=0;i<4;i++)
			a[i]=Integer.parseInt(arrA[i]);
		strInput=input.nextLine();
		String []arrS=strInput.split("");
		int numS=strInput.length();
		int []s=new int[numS+1];
		int result=0;
		for(int i=1;i<=numS;i++)
		{
			s[i]=Integer.parseInt(arrS[i]);
			result+=a[s[i]-1];
		}
		System.out.println(Integer.toString(result));

	}

}
