import java.util.Scanner;

public class ChoosingTeams {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		String strInput=input.nextLine();
		String []arr=strInput.split(" ");
		int n,k; //n=2000;
		n=Integer.parseInt(arr[0]);
		k=Integer.parseInt(arr[1]);
		int result=0;
		strInput=input.nextLine();
		arr=strInput.split(" ");
		for(int i=0;i<n;i++)
		{
			if(Integer.parseInt(arr[i])<=5-k)
				result++;
		}
		System.out.println(Integer.toString(result/3));

	}

}
