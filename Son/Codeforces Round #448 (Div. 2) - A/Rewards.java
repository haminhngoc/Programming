import java.util.Scanner;


public class Rewards {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String strInput;
		strInput=input.nextLine();
		String [] strA=strInput.split(" ");
		strInput=input.nextLine();
		String [] strB=strInput.split(" ");
		strInput=input.nextLine();
		int n;// 100
		int [] a=new int[3];
		int [] b= new int[3];
		n= Integer.parseInt(strInput);
		for(int i=0;i<3;i++)
		{
			a[i]=Integer.parseInt(strA[i]);
			b[i]=Integer.parseInt(strB[i]);
		}
		int numA, numB;
		numA=numB=0;
		for(int i=0;i<3;i++)
		{
			numA+=a[i];
			numB+=b[i];
		}
		int result=0;
		while(numA>0)
		{
			numA=numA-5;
			result++;
		}
		while(numB>0)
		{
			numB=numB-10;
			result++;
		}
		if(result>n)
			System.out.println("NO");
		else
			System.out.println("YES");
	}

}
