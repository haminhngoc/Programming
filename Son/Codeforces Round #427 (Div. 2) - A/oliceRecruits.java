import java.util.Scanner;
public class PoliceRecruits {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String strInput=input.nextLine();
		int n;//10^5
		n=Integer.parseInt(strInput);
		int [] arr= new int[n];
		strInput=input.nextLine();
		String[] strArr= strInput.split(" ");
		for(int i=0;i<n;i++)
		{
			arr[i]=Integer.parseInt(strArr[i]);
		}
		int result=0;
		int sumpolice=0;
		for(int i=0;i<n;i++)
		{
			if(arr[i]<0 && sumpolice<1)
				result++;
			else if(arr[i]<0 && sumpolice>0)
				sumpolice--;
			else if(arr[i]>0)
				sumpolice+=arr[i];
		}
		System.out.println(Integer.toString(result));
	}

}
