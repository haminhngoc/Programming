import java.util.Scanner;

public class Codeforce_441_B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int nDay = scan.nextInt();
		int vMax = scan.nextInt();
		int arrDay[] = new int[nDay + 1];
		int arrFruit[] = new int[nDay + 1];
		for (int i = 0; i < nDay; i++) {
			arrDay[i] = scan.nextInt();
			arrFruit[i] = scan.nextInt();
		}
		calFruitNumber(nDay, vMax, arrDay, arrFruit);
		scan.close();
	}

	private static void calFruitNumber(int nDay, int vMax, int[] arrDay,
			int[] arrFruit) {
		// TODO Auto-generated method stub

		// Sort 2 array --> arrDay increase
		for (int i = 0; i < nDay - 1; i++)
			for (int j = i + 1; j < nDay; j++)
				if (arrDay[i] > arrDay[j]) {
					int temp;
					temp = arrDay[i];
					arrDay[i] = arrDay[j];
					arrDay[j] = temp;
					temp = arrFruit[i];
					arrFruit[i] = arrFruit[j];
					arrFruit[j] = temp;
				}

		int nType1 = 0, nType2, rDay = arrDay[0], collectedFruit = 0, iDay = 0;
		int lastDay = arrDay[nDay - 1] + 1;
		arrDay[nDay] = lastDay;
		arrFruit[nDay] = 0;
		while (rDay <= lastDay) {
			nType2 = nType1;

			// update nType1:
			nType1 = 0;
			if (rDay < lastDay)
				while (rDay == arrDay[iDay]) {
					nType1 += arrFruit[iDay];
					iDay++;
				}
			//System.out.print(nType1 + " ");
			
			if ((nType1 + nType2) <= vMax) {				
				collectedFruit += nType1 + nType2;
				nType1 = 0;
			} else {
				collectedFruit += vMax;
				if (nType2 <= vMax) {
					nType1 -= (vMax - nType2);
				}
			}

			rDay++;
			//System.out.println(nType2 + " " + collectedFruit);
		}
		/*for (int i = 0; i < nDay; i++) {
			System.out.println(arrDay[i] + " " + arrFruit[i]);
		}*/
		
		System.out.println(collectedFruit);
	}
}
