import java.util.Scanner;
import java.util.Arrays;
public class SerejaandMugs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input= new Scanner(System.in);
		String strInput= input.nextLine();
		String [] arr=strInput.split(" ");
		int n=Integer.parseInt(arr[0]);// n=100
		int s=Integer.parseInt(arr[1]); //s=1000
		strInput=input.nextLine();
		arr=strInput.split(" ");
		Arrays.sort(arr);
		int sum=0;
		for(int i=0;i<n-1;i++)
			sum+=Integer.parseInt(arr[i]);
		if(sum<=s)
			System.out.println("YES");
		else
			System.out.println("NO");
		

	}

}
