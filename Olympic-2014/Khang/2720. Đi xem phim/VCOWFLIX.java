import java.util.*;

class VCOWFLIX {

	public static void main(String[] args) {
		VCOWFLIXSolver solver = new VCOWFLIXSolver();
		solver.solve();
	}

}

class VCOWFLIXSolver {
	private static Scanner in = new Scanner(System.in);

	public void solve() {
		int c = in.nextInt();
		int n = in.nextInt();

		int[] w = new int[n];
		for (int i = 0; i < n; i++) {
			w[i] = in.nextInt();
		}
		Arrays.sort(w);
		int[] dp = new int[n];
		dp[n - 1] = (w[n - 1] <= c) ? w[n - 1] : 0;
		dp[n - 2] = (w[n - 1] + w[n - 2]) <= c ? (w[n - 1] + w[n - 2])
				: w[n - 1];
		for (int i = n - 3; i >= 0; i--) {
			if (dp[i + 1] + w[i] <= c) {
				dp[i] = dp[i + 1] + w[i];
			} else {
				if (dp[i + 2] + w[i] <= c) {
					dp[i] = dp[i + 2] + w[i];
				}
				if (dp[i] < dp[i + 1]) {
					dp[i] = dp[i + 1];
				}
			}		
		}
		
		System.out.println(dp[0]);
	}
}
