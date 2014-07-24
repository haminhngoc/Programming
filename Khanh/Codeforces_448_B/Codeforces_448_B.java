import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Codeforces_448_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String s, t;
		s = scan.next();
		t = scan.next();
		int nS = s.length(), nT = t.length();
		char[] sortedS = s.toCharArray();
		char[] sortedT = t.toCharArray();
		if (checkAuto(sortedS, nS, sortedT, nT) == true)
			System.out.print("automaton");
		else {
			Arrays.sort(sortedS);
			Arrays.sort(sortedT);

			if (nS == nT) {
				int r = 1;
				for (int i = 0; i < nS; i++)
					if (sortedS[i] != sortedT[i])
						r = 0;
				if (r == 1)
					System.out.print("array");
				else System.out.print("need tree");
			} else {
				if (checkBoth(sortedS, nS, sortedT, nT) == true)
					System.out.print("both");
				else
					System.out.print("need tree");
			}
		}
		scan.close();
	}

	private static boolean checkAuto(char[] sortedS, int nS, char[] sortedT,
			int nT) {
		// TODO Auto-generated method stub
		int i=0, j=0;
		while ((i<nT)&&(j<nS))
		{
			if(sortedS[j]==sortedT[i])
				{
				i++;
				j++;
				}
			else j++;
		}
		if(i<nT)
		return false;
		else return true;
	}

	private static boolean checkBoth(char[] sortedS, int nS, char[] sortedT,
			int nT) {
		// TODO Auto-generated method stub
		boolean[] taken = new boolean[nS];
		for (int i = 0; i < nT; i++) {
			boolean found = false;
			for (int j = 0; j < nS; j++) {
				if ((sortedS[j] == sortedT[i]) && (taken[j] == false)
						&& (found == false)) {
					taken[j] = true;
					found = true;
				}
			}
			if (found == false)
				return false;
		}
		return true;
	}
}
