//import java.util.List;
import java.util.*;

public class DZYLovesFibonaccNumbers {

	public static void main(String[] args) {

		long MOD = 1000000009;

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 300K
		int m = sc.nextInt(); // 300K

		long[] a = new long[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		long[] sa = new long[n];
		sa[0] = a[0];
		for (int i = 1; i < n; i++) {
			sa[i] = (sa[i] + a[i]) % MOD;
		}

		int[][] queries = new int[m][3];
		for (int i = 0; i < m; i++) {
			queries[i][0] = sc.nextInt();
			queries[i][1] = sc.nextInt();
			queries[i][2] = sc.nextInt();
		}

		long[] F = new long[Math.max(n, 3) + 1];
		F[0] = 0; // F0
		F[1] = 1; // F1
		F[2] = 1; // F2, F3:2, F3:3
		for (int i = 3; i < n; i++) {
			F[i] = (F[i - 1] + F[i - 2]) % MOD;
		}
		long[] SF = new long[Math.max(n, 3) + 1];
		SF[0] = 0;
		for (int i = 1; i < n; i++) {
			SF[i] = (SF[i] + F[i]) % MOD;
		}

		long[] cacheIn = new long[n];
		long[] cacheOut0 = new long[n];
		long[] cacheOut1 = new long[n];
		for (int i = 0; i < m; i++) {
			int l = queries[i][1];
			int r = queries[i][2];
			if (queries[i][0] == 1) {
				cacheIn[l - 1] = (cacheIn[l - 1] + F[1]) % MOD;
				cacheOut0[r - 1] = (cacheOut0[r - 1] + F[r - l]) % MOD;
				cacheOut1[r - 1] = (cacheOut1[r - 1] + F[r - l + 1]) % MOD;
			} else {
				long u0 = 0;
				long u1 = 0;
				long temp = 0;
				for (int j = 0; j < n; j++) {
					temp = u1;
					u1 = (u1 + u0) % MOD;
					u0 = temp;
					u1 = (u1 + cacheIn[j]) % MOD;
					a[j] = (a[j] + u1) % MOD;
					if (cacheOut1[j] > 0) {
						u1 = (u1 - cacheOut1[j] + MOD) % MOD;
						u0 = (u0 - cacheOut0[j] + MOD) % MOD;
					}
				}
				long res = 0;
				for (int j = l - 1; j < r; j++) {
					res = (res + a[j]) % MOD;
				}
				System.out.println(res);
				for (int j = 0; j < n; j++) {
					cacheIn[j] = 0;
					cacheOut0[j] = 0;
					cacheOut1[j] = 0;
				}
			}
		}
	}
}
