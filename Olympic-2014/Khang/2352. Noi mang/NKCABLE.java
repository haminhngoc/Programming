import java.io.*;
import java.util.*;

class NKCABLE {

	public static void main(String[] args) {
		Solver solver = new Solver();
		solver.solve();
	}

}

class Solver {

	private static Scanner in = new Scanner(System.in);

	public void solve() {
		int n = in.nextInt();
		int[] d = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			d[i] = in.nextInt();
		}

		switch (n) {
			case 1:
				System.out.println(0);
				return;				
			case 2:
				System.out.println(d[0]);
				return;
			case 3:
				System.out.println(d[0] + d[1]);
				return;
		}		

		int[] dp = new int[n - 1];
		dp[0] = d[0];
		dp[1] = d[0] + d[1];
		for (int i = 2; i < n - 1; i++) {
			dp[i] = Math.min(dp[i - 2] + d[i], dp[i - 1] + d[i]);
		}
		System.out.println(dp[n - 2]);
	}
}
