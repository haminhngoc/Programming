import java.util.*;

class TPCDLCS {

	public static void main(String[] args) throws Exception {
		solve();
	}

	static void solve() {
		Scanner sc = new Scanner(System.in);

		char[] gen1 = sc.nextLine().toCharArray();
		int len1 = gen1.length;

		char[] gen2 = sc.nextLine().toCharArray();
		int len2 = gen2.length;

		Match[][] matches = new Match[len1][len2];
		for (int i = 0; i < len1; i++) {
			Match[] rowi = new Match[len2];
			for (int j = 0; j < len2; j++) {
				rowi[j] = new Match();
			}
			matches[i] = rowi;
		}

		// Duy is coding => Maybe canceled
		for (int i = 0; i < len1; i++) {
			char nu1 = gen1[i];
			Match[] rowi = matches[i];
			for (int j = 0; j < len2; j++) {
				if (i == 0) {
					if (nu1 == gen2[j]) {
						Match cell = rowi[j];
						cell.maxMatch = 1;
						cell.matchIndex = j;
					}
				}
				else{
					Match[] preRow = matches[i-1];
				}
			}
		}
	}

	static class Match
	{
		public int maxMatch = 0;
		public int matchIndex = -1;
		public int preMatch = -1;
	}
}