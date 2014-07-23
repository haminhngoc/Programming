import java.util.Scanner;

public class Codeforces_448_C {
	static int n;
	static int a[] = new int[5000];
	static int result;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		result = n;
		for (int i = 0; i < n; i++)
			a[i] = scan.nextInt();
		if (n == 1)
			result = 1;
		else
			CalculateResult(0, 0, n - 1);
		System.out.print(result);
		scan.close();
	}

	private static void CalculateResult(int lastMin, int iStart, int iEnd) {
		// TODO Auto-generated method stub

		int sMin = 1, min = a[iStart];
		for (int i = iStart + 1; i <= iEnd; i++) {
			if (a[i] == min)
				sMin++;
			if (a[i] < min) {
				min = a[i];
				sMin = 1;
			}
		}

		if (sMin >= min - lastMin)
		{
			result -= (sMin - min + lastMin);
			lastMin=min;
		}

		int newStart = iStart, newEnd = iEnd;
		int i = iStart;
		while (i <= iEnd) {
			newEnd = iStart;
			newStart = iStart;
			if (a[i] == min) {
				// update newEnd & newStart
				if ((i > iStart) && (i < iEnd)) {
					newEnd = i - 1;
					newStart = i + 1;
				}
				if (i == iStart) {
					newStart = i + 1;
					newEnd = i;
				}
				if (i == iEnd) {
					newStart = iEnd;
					newEnd = i - 1;
				}
				if (newEnd - iStart > 0)
					CalculateResult(lastMin, iStart, newEnd);
				iStart = newStart;
			}
			i++;
		}
		if (iEnd - iStart > 0)
			CalculateResult(lastMin, iStart, iEnd);
	}
}
