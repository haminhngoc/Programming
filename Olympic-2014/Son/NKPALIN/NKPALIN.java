import java.util.Scanner;

class NKPALIN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		String s = reader.nextLine();
		char[] a = s.toCharArray();
		int n = a.length;// n=2000;
		int count = 0;
		int max = 0;
		String result = "";
		String tmp = "";
		for (int i = 0; i < n; i++) {
			int l = i;
			int r = n - 1;
			count = 0;
			tmp = "";
			int index = 0;
			int indexr=n-1;
			while (l < n - 1 && r>=0) {
				if (a[l] == a[r] && r>l) {
					count++;
					tmp += a[l];
					l++;
					index = l;
					indexr=r--;
					System.out.println(tmp);

				}
				r--;
				else if (r == l ) {
					r = indexr;
					l++;
				}
			}
			count++;
			tmp = tmp + a[index];
			if (count > max) {
				max = count;
				result = tmp.toString();
			}
		}
		char[] r = result.toCharArray();
		int len = r.length - 1;
		for (int i = len-1; i >= 0; i--)
			result += r[i];
		System.out.println(result);
	}

}
