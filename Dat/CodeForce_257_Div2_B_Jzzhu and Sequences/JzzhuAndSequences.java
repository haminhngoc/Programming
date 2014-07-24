import java.util.Scanner;
import java.lang.*;
public class JzzhuAndSequences {
	private static Scanner readers = new Scanner(System.in);

	public static void main(String[] args) {
		int f1, f2, n, f3 = 0;
		f1 = readers.nextInt();
		f2 = readers.nextInt();
		n = readers.nextInt();
		int result=0;
		if (n > 2) {
			int du= n%3;
			if(du==1) f3=(int) (-f1*Math.pow(-1,n%2));
			if(du==2) f3= (int) (f2*Math.pow(-1,n%2));
			if(du==0) 
			{
				f1=(int) (-f1*Math.pow(-1,(n-2)%2));
				f2=(int) (f2*Math.pow(-1,(n-1)%2));
				f3=f2-f1;
			}
		}
		else if(n==1) f3=f1;
		else if(n==2)f3=f2;
		while(f3<0)
		{
			f3=f3%1000000007+1000000007;
		}
		result= f3%1000000007;//Math.floorMod(f3, 2);
		System.out.print(result);
	}

}
