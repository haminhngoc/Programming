import java.util.Scanner;


public class BASEH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader= new Scanner(System.in);
		long k;//k=10^9;
		int h;
		k=reader.nextLong();
		h=reader.nextInt();
		String result=Long.toBinaryString(k);
		System.out.print(result);

	}

}
