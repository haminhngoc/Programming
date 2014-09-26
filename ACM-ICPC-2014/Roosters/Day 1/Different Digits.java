import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) {
		solve();

	}

	static void solve() {
		int n;
		int m;
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			n = in.nextInt();
			m = in.nextInt();
			int cnt = 0;
			for (int i = n; i <= m; i++) {
				if (check(i)) {
					cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

	private static boolean check(int i) {
		int[] numbs = new int[10];
		StringBuffer tmp = new StringBuffer();
		char[] numb = tmp.append(i).toString().toCharArray();
		for (int j = 0; j < numb.length; j++) {
			if (numbs[numb[j] - '0'] == 0) {
				numbs[numb[j] - '0']++;
			} else if (numbs[numb[j] - '0'] != 0) {
				return false;
			}
		}
		return true;
	}
}
