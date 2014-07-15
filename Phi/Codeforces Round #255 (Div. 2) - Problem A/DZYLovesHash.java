import java.util.Arrays;
import java.util.BitSet;
import java.util.Scanner;

public class DZYLovesHash {

	protected static final int max = 300;
	private static BitSet bs = new BitSet(max);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int p, n, ith, i;
		p = sc.nextInt();
		n = sc.nextInt();
		
		for (i = 1; i <= n; i++) {
			ith = sc.nextInt();
			if (bs.get(ith % p))
			{
				System.out.println(i);
				break;
			}
			bs.set(ith % p,true);
		}
		if (i > n)
		{
			System.out.println(-1);
		}
		sc.close();
	}

}
