import java.util.Scanner;

public class Squats {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String strInput=input.nextLine();
		int n=Integer.parseInt(strInput); // n=200;
		strInput=input.nextLine();
		char[] arr;
		arr=strInput.toCharArray();
		int down=0;
		for(int i=0;i<n;i++)
		{
			if((int)arr[i]==120)
				down++;
		}
		if(down>=n/2)
		{
			down=down-n/2;
			System.out.println(Integer.toString(down));
			int tmp=0;
			for(int i=0;i<n;i++)
			{
				if(tmp<down &&(int)arr[i]==120)
				{
					System.out.print("X");
					tmp++;
				}
				else
					System.out.print(arr[i]);
			}
		}
		else
		{
			down=n/2-down;
			System.out.println(Integer.toString(down));
			int tmp=0;
			for(int i=0;i<n;i++)
			{
				if(tmp<down &&(int)arr[i]!=120)
				{
					System.out.print("x");
					tmp++;
				}
				else
					System.out.print(arr[i]);
			}
		}
			
	}

}
