import java.util.Scanner;

public class Codeforces_450_C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt(), m = scan.nextInt(), k = scan.nextInt();
		int nCut = 1, mCut = 1;

		if (k > (m + n - 2))
			System.out.println(-1);
		else {
			float minArea =(float) m * n;
			if (k > 10) {
				float pn=(float)(n-1)/(m+n-2), pm=(float)(m-1)/(m+n-2);
				nCut = Math.round(k*pn-1);
				mCut=1;
				//mCut = Math.round(k*pm-1);
				//System.out.print(nCut+" "+mCut);
			}

			while (mCut+nCut-2 < k) {
				int mS = m, nS = n;
				mS = m / mCut;
				nS = n / nCut;

				float areamPlus =(float) nS * (m / (mCut + 1));
				float areanPlus =(float) mS * (n / (nCut + 1));
				if (areamPlus == areanPlus) {
					minArea = areanPlus;
					if (m > n)
						mCut++;
					else
						nCut++;
				} else {
					if (areamPlus > areanPlus) {
						mCut++;
						minArea = areamPlus;
					} else {
						nCut++;
						minArea = areanPlus;
					}
				}
				//System.out.println(areamPlus + " " + areanPlus + " " + minArea);
			}
			System.out.println(Math.round(minArea));
		}
		scan.close();
	}

}
