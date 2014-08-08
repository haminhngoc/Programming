import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DZYLovesHash {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {

		int p = reader.nextInt();
		int nLine = reader.nextInt();
		int[] numbers = new int[nLine];
		int conflictPosition = -1;
		List<Integer> filledBuckets = new ArrayList<Integer>();
		for (int i = 0; i < nLine; i++) {
			numbers[i] = reader.nextInt();
		}	
		
		for (int i = 0; i < nLine; i++) {			
			int hashfunction = numbers[i] % p;
			if (filledBuckets.contains(new Integer(hashfunction))) {
				conflictPosition = i + 1;
				break;
			} else {
				filledBuckets.add(new Integer(hashfunction));
			}
		}
		System.out.println(conflictPosition);
	}

}
