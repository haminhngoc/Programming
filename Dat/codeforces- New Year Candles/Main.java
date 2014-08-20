import java.util.Scanner;

public class Main {
	private static Scanner readers = new Scanner(System.in);

	public static void main(String[] args) {
		int a = 0, b = 0,total=0;
		a = readers.nextInt();
		b = readers.nextInt();
		total=a;
		while(a/b>0)
		{
			int du=0;
			if(a%b>0) du=a%b;
			a=a/b;
			total+=a;
			a+=du;
		}
		System.out.print(total);
	}

}
