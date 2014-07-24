import java.util.Scanner;
public class JzzhuandSequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input =new Scanner(System.in);
		int x,y; //x=y=10^9
		int n; // n=2*10^9
		x=input.nextInt();
		y=input.nextInt();
		n=input.nextInt();
		input.close();
		int result=0;
		int [] arr =new int[6];
		arr[0]=-y+x;
		arr[1]=x;
		arr[2]=y;
		arr[3]=y-x;
		arr[4]=-x;
		arr[5]=-y;
		
		result=arr[n%6];
		result=result%1000000007;
		if(result>=0)
			System.out.println(Integer.toString(result));
		else
			System.out.println(Integer.toString(result+1000000007));
	}
	
}

