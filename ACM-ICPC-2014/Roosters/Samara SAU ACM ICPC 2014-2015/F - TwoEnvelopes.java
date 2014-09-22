import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int count = 0;
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();

		if(c >= (b/2 +1)*2 )
		{
			System.out.println("Stay with this envelope");
			return;
		}
		else if(c%2 ==1)
		{
			System.out.println("Take another envelope");
			return;
		}
		else if(c<a*2)
		{
			System.out.println("Take another envelope");
			return;
		}
		else{
			System.out.println("Take another envelope");
			return;
		}
	}
}