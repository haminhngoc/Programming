import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GeneratateNumber {
	public static void main(String[] args) {

		// random(50000);
		List<Long> list = generatePrimeList(100000);
		long temp;
		long j;
		long size = list.size();
		for (Long i = (long) 2; i <= 100000; ++i) {
			if (Collections.binarySearch(list, i) < 0) {
				for (j = 0; j < size; ++j) {
					if (i < list.get((int) j)
							&& Collections.binarySearch(list, i - 4) < 0) {
						System.out.println(i);
						break;
					}
					if (Collections.binarySearch(list, i - list.get((int) j)) >= 0) {
						break;
					}
				}
				if (j == size && Collections.binarySearch(list, i - 4) < 0) {
					System.out.println(i);
				}

			}
		}

	}

	static void random(int number) {
		Random rand = new Random();
		for (int i = 0; i < number; ++i) {
			System.out.println(Math.abs((rand.nextLong() % 50000)));
		}
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
