import java.util.*;
import java.io.*;

class Main1 {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		Scanner in = new Scanner(System.in);
		int n;

		while ((n = in.nextInt()) != 0) {

			String[] names = new String[n];
			for (int i = 0; i < n; i++) {
				names[i] = in.next();
			}
			Arrays.sort(names);

			solve1(n, names);

		}
	}

	private static void solve1(int n, String[] names) {
		StringBuilder res;
		res = new StringBuilder();
		int mid = n / 2 - 1;
		int midlength = names[mid].length();
		int nextlength = names[mid + 1].length();

		for (int i = 0; i < midlength; ++i) {
			char a = names[mid].charAt(i);
			char b = names[mid + 1].charAt(i);
			if (a == b) {
				res.append(a);
			} else {
				if (i == midlength - 1) {
					res.append(a);
				} else if (a + 1 != b) {
					res.append((char) (a + 1));
				} else if (i != nextlength - 1) {
					res.append(b);
				} else {
					res.append(a);
					for (i = i + 1; i < midlength - 1; ++i) {
						a = names[mid].charAt(i);
						if (a == 'Z') {
							res.append(a);
						} else {
							res.append((char) (a + 1));
							System.out.println(res);
							return;
						}
					}
					res.append(names[mid].charAt(midlength - 1));
				}

				break;
			}

		}
		System.out.println(res);

	}
}
