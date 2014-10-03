import java.util.*;

class Solve21086 {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		char[] arr = reader.nextLine().toCharArray();
		int length = arr.length;
		int[][] label = new int[2][length + 1];
		int[] add = new int [length+1];
		int count = 0;
		boolean isCounting = false;
		int max = 0;
		for (int i = 0; i < length; i++) {			
			if (arr[i] == '7') {
				count++;
				label[0][1]++;
				isCounting = true;
				if (i == length - 1 && count > 1) {
					label[0][count]++;
					label[1][count] = 1;
					max = Math.max(count, max);
				}
			} else if (isCounting) {
				isCounting = false;
				if (count > 1) {
					label[0][count]++;
					label[1][count] = 1;
				}
				max = Math.max(count, max);
				count = 0;
			}			
		}
		//showList(label, max);

		for (int i = max; i >= 2 ; i--) {
			if (label[1][i] == 1) {
				for (int j = i - 1; j >= 2; j--) {
					add[j] += (i - (j - 1)) * label[0][i];					
				}
			}
			//showList(label, max);
		}

		for (int index = 0; index <= length; index++) {
			if (label[0][index] > 0 || add[index] > 0) {
				System.out.println(index + " " + (label[0][index] + add[index]));
			}
		}
	}
	
	private static void showList(int[][] list, int length) {
		for (int i = 0; i < length; i++) {
			System.out.print(i + ":" + list[0][i] + " " + "(" + list[1][i] + ")" + "   ");
		}
		System.out.println();
	}

}
