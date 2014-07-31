import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Domino {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		Domino d = new Domino();
		d.doWork();
	}

	public void doWork() {
		int nDomino = reader.nextInt();
		int[] upperHalfs = new int[nDomino];
		int[] lowerHalfs = new int[nDomino];
		int[] numberOfCategories = new int[] { 0, 0, 0 };
		for (int i = 0; i < nDomino; i++) {
			upperHalfs[i] = reader.nextInt();
			lowerHalfs[i] = reader.nextInt();
		}
		Categorize(upperHalfs, lowerHalfs, numberOfCategories);

		if (numberOfCategories[2] % 2 != 0) {

			if (numberOfCategories[0] % 2 == 0
					&& numberOfCategories[1] % 2 == 0) {
				if (numberOfCategories[0] != 0 || numberOfCategories[1] != 0)
					System.out.println(1);
				else
					System.out.println(-1);
			} else if (numberOfCategories[0] % 2 == 1
					&& numberOfCategories[1] % 2 == 1) {
				System.out.println(0);
			} else {
				System.out.println(-1);
			}

		} else {
			if (numberOfCategories[0] % 2 == 0
					&& numberOfCategories[1] % 2 == 0) {
				System.out.println(0);
			} else if (numberOfCategories[0] % 2 == 1
					&& numberOfCategories[1] % 2 == 1) {
				System.out.println(1);
			} else {
				System.out.println(-1);
			}

		}

	}

	public void Categorize(int[] UpperArray, int[] LowerArray,
			int[] numberOfCategories) {
		for (int i = 0; i < UpperArray.length; i++) {
			if (UpperArray[i] % 2 == 0 && LowerArray[i] % 2 != 0) {
				numberOfCategories[0]++;
			} else if (UpperArray[i] % 2 != 0 && LowerArray[i] % 2 == 0) {
				numberOfCategories[1]++;
			} else if (UpperArray[i] % 2 != 0 && LowerArray[i] % 2 != 0) {
				numberOfCategories[2]++;
			}
		}
	}

	public int Sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

}
