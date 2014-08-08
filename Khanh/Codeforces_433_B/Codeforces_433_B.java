import java.util.Arrays;
import java.util.Scanner;

public class Codeforces_433_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] v = new int[n];
		long[] sV = new long[n];
		v[0] = scan.nextInt();
		sV[0] = v[0];
		if (n > 1) {
			for (int i = 1; i < n; i++) {
				v[i] = scan.nextInt();
				sV[i] = v[i] + sV[i - 1];
			}
		}
		Arrays.sort(v);
		/*
		 * for(int i=0; i<n-1; i++) for (int j=i+1; j<n; j++) { if(v[i]>v[j]) {
		 * int temp=v[i]; v[i]=v[j]; v[j]=temp; } }
		 */
		long[] sU = new long[n];
		sU[0] = v[0];
		for (int i = 1; i < n; i++)
			sU[i] = sU[i - 1] + v[i];
		int m = scan.nextInt();
		long result[] = new long[m];
		for (int i = 0; i < m; i++) {
			int type = scan.nextInt(), l = scan.nextInt(), r = scan.nextInt();
			if (type == 1) {
				if (l == 1)
					result[i] = sV[r - 1];
				else
					result[i] = sV[r - 1] - sV[l - 2];
			} else {
				if (l == 1)
					result[i] = sU[r - 1];
				else
					result[i] = sU[r - 1] - sU[l - 2];
			}
		}
		for (int i = 0; i < m; i++)
			System.out.println(result[i]);
		scan.close();
	}

}
