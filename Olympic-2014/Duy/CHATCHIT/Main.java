import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class CHATCHIT {
	public static void main(String[] args) {
		solve();
	}

	static void solve() {
		Scanner in = new Scanner(System.in);
		String[] rw = new String[] { "k", "ko", "ng", "n", "dc", "hok", "ntn",
				"kq" };
		String[] rwConverted = new String[] { "khong", "khong", "nguoi",
				"nhieu", "duoc", "khong", "nhu the nao", "ket qua" };
		String[] q = new String[] { "j", "w", "f", "dz", "z" };
		String[] qConverted = new String[] { "gi", "qu", "ph", "d", "d" };
		while (in.hasNext()) {
			String a = in.next();
			boolean flag = false;
			for (int i = 0; i < rw.length; i++) {
				if (a.equals(rw[i])) {
					a = rwConverted[i];
					flag = true;
				}
			}
			if (!flag) {
				for (int i = 0; i < q.length; i++) {
					if (a.contains(q[i])) {
						a = a.replace(q[i], qConverted[i]);
					}
				}
			}
			System.out.print(a + " ");
		}

	}
}

