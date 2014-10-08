import java.io.*;
import java.util.*;

class solve2299 {

	public static void main(String[] args) {
		NKTICKSolver solver = new NKTICKSolver();
		solver.solve();
	}
}

class NKTICKSolver {
	private static Scanner in = new Scanner(System.in);

	public void solve() {
		int n = in.nextInt();
		int[] t = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < n; i++) {
			t[i] = in.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {
			r[i] = in.nextInt();
		}
		int[] dp = new int[n];
		dp[0] = t[0];
		dp[1] = Math.min(r[0], t[0] + t[1]);
		for (int i = 2; i < n; i++) {
			dp[i] = Math.min(dp[i - 2] + r[i - 1], dp[i - 1] + t[i]);
		}	
		System.out.println(dp[n - 1]);
	}
}