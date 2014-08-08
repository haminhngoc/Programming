import java.util.Scanner;

public class Codeforces_454_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		double r = 0;
		for (int i = m; i > 0; i--) {
			r += Chose(m, n, i);
		}
		System.out.println(r);
		scan.close();
	}

	private static double Chose(int m, int n, int i) {
		// TODO Auto-generated method stub
		double r = 0;
		for (int j = n; j > 0; j--) {
			double result = 1;
			for (int k = 1; k <= n; k++) {
				result *= (double) k;
				if (k <= j)
					result /= k;
				if (k <= n - j)
					result /= k;
			}
			r += result * exp(i - 1, n - j);
			//System.out.print(r+"x"+i+"x"+exp((float) 1 / m, n)+" ");
		}
		return r * i * exp((double) 1 / m, n);
	}

	private static double exp(double m, int n) {
		// TODO Auto-generated method stub
		double result = 1;
		if (n > 0)
			for (int i = 0; i < n; i++) {
				result *= m;
			}
		return result;
	}

}
