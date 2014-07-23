import java.util.Scanner;


public class JzzhuAndChocolate {
	private static Scanner readers = new Scanner(System.in);
	public static void main(String[] args) {
		int n,m,k;
		n=readers.nextInt();
		m=readers.nextInt();
		k=readers.nextInt();
		int totalCutMax=m+n-2;
		if(k>totalCutMax)System.out.print(-1);
		else{
			int temp=1;
			while(Math.pow(k, temp)%(m*n)0)
		}
	}

}
