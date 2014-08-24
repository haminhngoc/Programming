import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


 class J {

	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		int N = in.nextInt();
		List<Long> l = generatePrimeList(1000);
		

	}
	private static List<Long> generatePrimeList(int limit) {
		List<Long> result = new ArrayList<Long>();
		result.add((long) 2);
		result.add((long) 3);
		int resultSize = 2;
		int end;
		int j;
		for (int i = 5; i <= limit; i += 2) {
			end = (int) Math.sqrt(i);
			j = 0;
			while (j < resultSize && result.get(j) <= end) {
				if (i % result.get(j) == 0) {
					break;
				}
				j++;

			}
			if (j >= resultSize || result.get(j) > end) {
				result.add((long) i);
				resultSize++;
			}

		}
		return result;
	}
}
