import java.util.Arrays;
import java.util.Scanner;

public class Codeforces_430_A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt();
		int a[] = new int[n];
		int nodeArr[] = new int[n + m * 2];
		for (int i = 0; i < n; i++) {
			a[i] = scan.nextInt();
			nodeArr[i] = a[i];
		}
		int iArr = n-1;
		for (int i = 0; i < m; i++) {
			nodeArr[iArr++] = scan.nextInt();
			nodeArr[iArr++] = scan.nextInt();
		}
		Arrays.sort(nodeArr);
		int nArr = iArr++;
		int resultArr[] = new int[101];
		int x = 1;
		resultArr[nodeArr[0]] = 0;
		for (int i = 1; i < nArr; i++) {
			if (nodeArr[i] > nodeArr[i - 1]) {
				resultArr[nodeArr[i]] = x;
				if (x == 1)
					x = 0;
				else
					x = 1;
			}
		}
		for (int i = 0; i < n; i++)
			System.out.print( resultArr[a[i]]+ " ");
		scan.close();
	}

}
