import java.util.Scanner;

public class Codeforces_424_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		String sA = scan.next();
		char s[] = new char[n];
		s = sA.toCharArray();
		int nX = 0;
		for (int i = 0; i < n; i++)
			if (s[i] == 'X')
				nX++;
		int r = nX - n / 2;
		if (r == 0) {
			System.out.println(0);
			System.out.println(sA);
		} else if (r > 0) {
			System.out.println(r);
			int i = 0;
			while (r > 0) {
				if (s[i] == 'X') {
					s[i] = 'x';
					r--;
				}

				i++;
			}
			for (int j = 0; j < n; j++)
				System.out.print(s[j]);
		} else {
			r = -r;
			System.out.println(r);
			int i = 0;
			while (r > 0) {
				if (s[i] == 'x') {
					s[i] = 'X';
					r--;
				}

				i++;
			}
			for (int j = 0; j < n; j++)
				System.out.print(s[j]);
		}
		scan.close();
	}

}
