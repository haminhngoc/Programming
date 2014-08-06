import java.util.Arrays;
import java.util.Scanner;

public class TheChildandHomework {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int nAnswer = 4;
		String[] answers = new String[4];
		for (int i = 0; i < 4; i++) {
			answers[i] = reader.nextLine().trim();
		}
		BubbleSort(answers);
		if ((answers[nAnswer - 1].length() - 2) >= 2 * (answers[nAnswer - 2].length() - 2)
				&& (answers[nAnswer - 1].length() - 2) >= 2 * (answers[0]
						.length() - 2)) {
			System.out.println(answers[nAnswer - 1].charAt(0));
		} else if ((answers[0].length() - 2) * 2 <= (answers[nAnswer - 1].length() - 2)
				&& (answers[0].length() - 2) * 2 <= answers[1].length() - 2) {
			System.out.println(answers[0].charAt(0));
		} else {
			System.out.println("C");
		}
	}

	public static void BubbleSort(String[] arr) {
		boolean swapped = false;
		do {
			swapped = false;
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i].length() > arr[i + 1].length()) {
					swap(arr, i, i + 1);
					swapped = true;
				}
			}
		} while (swapped);
	}

	public static void swap(String[] arr, int index0, int index1) {
		String temp = arr[index0];
		arr[index0] = arr[index1];
		arr[index1] = temp;
	}

}
