import java.util.Scanner;

public class Codeforces_431_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int[] a = new int[4];
		for (int i = 0; i < 4; i++)
			a[i] = scan.nextInt();
		String s = scan.next();
		int n = s.length(), sum = 0;
		char[] c = new char[n];
		c = s.toCharArray();
		for (int i = 0; i < n; i++) {
			int x=c[i]-49;
			//System.out.println(x);
			sum += a[x];
		}
		System.out.println(sum);
		scan.close();
	}

}
