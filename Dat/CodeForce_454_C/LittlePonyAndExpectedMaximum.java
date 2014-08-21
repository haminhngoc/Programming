import java.util.Scanner;


public class LittlePonyAndExpectedMaximum {
private static Scanner readers = new Scanner(System.in);
	public static void main(String[] args) {
		float m,n;
		m=readers.nextInt();
		n=readers.nextInt();
		float total=0;
		for(int i=1;i<=m;i++)
		{
			total+=	(Math.pow((i/m), n)-Math.pow((i-1)/m, n));
			System.out.print(total+"\n");
		}
		System.out.print(total);
	}

}
