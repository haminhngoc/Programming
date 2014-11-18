import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;

class PTIT124C {
	public static void main(String[] args) throws NumberFormatException, IOException {
		solve();
	}

	static BufferedReader reader = new BufferedReader(new InputStreamReader(
			System.in), 32768);

	static void solve() throws NumberFormatException, IOException {
		int n = Integer.parseInt(reader.readLine());
		for (int id = 1; id <= n; id++) {
			int max = 0;
			int cur = 0;
			char[] a = reader.readLine().toCharArray();
			for (int i = 0; i < a.length; i++) {
				if (a[i] == '[') {
					cur++;
				} else {
					cur--;
				}
				max = Math.max(cur, max);
			}
			BigInteger two = new BigInteger("2");
			BigInteger res = two.pow(max);
			System.out.println(id + " " + res);
		}
	}
}

