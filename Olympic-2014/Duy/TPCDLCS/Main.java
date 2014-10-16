import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException {
		Init(is);
		solve();
	}

	static StringBuilder res = new StringBuilder();

	static void solve() throws IOException {
		char[] s1 = Next().toCharArray();
		char[] s2 = Next().toCharArray();

		int n1 = s1.length;
		int n2 = s2.length;
		String[][] dp = new String[n1 + 1][n2 + 1];
		for (int i = 0; i <= n1; i++) {
			Arrays.fill(dp[i], "");
		}
		for (int i = 1; i <= n1; i++) {
			for (int j = 1; j <= n2; j++) {
				if (s1[i - 1] == s2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + s1[i - 1];
				} else {
					if (dp[i][j - 1].length() > dp[i - 1][j].length()) {
						dp[i][j] = dp[i][j - 1];
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}
		}
		int max = dp[n1][n2].length();
		List<String> ans = new ArrayList<String>();
		for (int i = n2; i >= 0; i--) {
			if (!dp[n1][i].isEmpty() && dp[n1][i].length() == max
					&& !ans.contains(dp[n1][i])) {
				ans.add(dp[n1][i]);
			}
		}
		Collections.sort(ans);
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < ans.size(); i++) {
			res.append(ans.get(i) + "\n");
		}
		System.out.println(ans.size());
		System.out.print(res);
	}

	/******************************************************************
	 ****************************** READER*****************************
	 ******************************************************************/
	static BufferedReader reader;
	static StringTokenizer tokenizer;
	static InputStream is = System.in;

	static void Init(InputStream in) {
		reader = new BufferedReader(new InputStreamReader(in));
		tokenizer = new StringTokenizer("");
	}

	static String Next() throws IOException {

		while (!tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(reader.readLine());
		}
		return tokenizer.nextToken();
	}

	static int NextInt() throws IOException {

		return Integer.parseInt(Next());
	}

	static long NextLong() throws IOException {

		return Long.parseLong(Next());
	}

	static Double NextDouble() throws IOException {

		return Double.parseDouble(Next());
	}
}
