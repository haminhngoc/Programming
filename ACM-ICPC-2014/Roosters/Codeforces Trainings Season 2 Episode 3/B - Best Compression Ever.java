import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		int b = in.nextInt();
		long t = (long) (Math.pow(2, b + 1) - 1);
		if(t>=n){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}

}