import java.util.Arrays;
import java.util.Scanner;

class C11SEQ3_12963 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		long F[] = new long[111];
		F[1] = 1;
		for (int i = 2; i <= 110; i++) {
			long x = F[i - 1] * 2;
			while(x%10==0)x/=10;
			F[i] = Fix(x);
		}
		/*for(int i=1000-18; i<=1000; i++)
		System.out.println(i+" "+F[i]);*/
		if(N>110)System.out.println(F[N%6+96]);
		else System.out.println(F[N]);
		scan.close();
	}

	private static long Fix(long x) {
		// TODO Auto-generated method stub
		String s = "" + x;
		char arrS[] = s.toCharArray();
		Arrays.sort(arrS);
		long r = 0;
		int n = s.length();
		for (int i = n - 1; i >= 0; i--) {
			r += (long) ((int) arrS[i] - (int) '0') * Math.pow(10, n - 1 - i);
		}
		return r;
	}

}
