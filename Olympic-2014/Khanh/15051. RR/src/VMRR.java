import java.util.Scanner;

class VMRR {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		int size = s.length();
		char[] c = s.toCharArray();
		String xy = scan.nextLine();
		char X = xy.charAt(0);
		char Y = xy.charAt(1);
		int[] count = new int[size];
		if (c[0] == X)
			count[0] = 1;
		else
			count[0] = 0;
		for (int i = 1; i < size; ++i)
			if (c[i] == X)
				count[i] = count[i - 1] + 1;
			else
				count[i] = count[i - 1];
		long result = 0;
		for (int i = size - 1; i > 0; --i)
			if (c[i] == Y)
				result += count[i - 1];
		System.out.println(result);
		scan.close();
	}
}