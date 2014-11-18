import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

class NUMCON {
	public static void main(String[] args) throws IOException {
		solve();
	}

	static String[] s;
	static String[] b;

	static void solve() throws IOException {
		String line = nextLine();
		s = line.split(" ");
		b = Arrays.copyOf(s, s.length);
		int max = 0;
		for (int i = 0; i < s.length; i++) {
			max = Math.max(s[i].length(), max);
		}
		for (int i = 0; i < s.length; i++) {
			while (s[i].length() < max) {
				s[i] += 0;
			}
		}
		number[] nums = new number[s.length];
		for (int i = 0; i < s.length; i++) {
			nums[i] = new number();
			nums[i].pos = i;
			nums[i].num = s[i];
		}
		Arrays.sort(nums, new Comparator<number>() {

			@Override
			public int compare(number n1, number n2) {
				if (n1.num.compareTo(n2.num) == 0) {
					return b[n1.pos].length() > b[n2.pos].length() ? -1 : 1;
				}
				return n1.num.compareTo(n2.num);
			}
		});
		StringBuilder res = new StringBuilder();
		for (int i = s.length - 1; i >= 0; i--) {
			if (b[nums[i].pos].charAt(0) == '-') {
				System.out.print(b[nums[i].pos]);
				continue;
			}
			res.append(b[nums[i].pos]);
		}
		System.out.println(res);
	}

	/*****************************************************************
	 ******************** BASIC READER *******************************
	 *****************************************************************/

	static InputStream is = System.in;
	static byte[] a;

	static void readByte() {
		a = new byte[32768];
		try {
			is.read(a);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static String nextLine() {
		readByte();
		StringBuilder line = new StringBuilder();
		int i = 0;
		while (a[i] != 0) {
			if (a[i] == 13) {
				line.append(" ");
			}
			if (a[i] > 33 && a[i] < 126) {
				line.append((char) a[i]);
			}
			i++;
		}
		return line.toString();
	}
}

class number {
	int pos;
	String num;
}

