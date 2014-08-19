import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class GeneratateNumber {
	public static void main(String[] args) throws FileNotFoundException,
			UnsupportedEncodingException {

		/*
		 * // random(50000); Random rand = new Random(); int n = 10;//
		 * rand.nextInt() % + 10; System.out.println(n); int result = 0; int
		 * temp = 0; for (int i = 1; i <= n; ++i) { temp =
		 * Math.abs(rand.nextInt())%5000; if (i == 1) { result = temp; } else {
		 * result ^= temp; } for (int j = 1; j <= n; ++j) { result = result ^ (i
		 * % j); } System.out.print(temp + " "); } System.out.println("\n" +
		 * result);
		 */
		List<Long> list = generatePrimeList(100000);
		// System.out.println(list.size());
		/*
		 * System.out.println(10000); for(int i = 10000; i>0; i--){
		 * System.out.print(i + " "); if(i%100==0){ System.out.println(); } }
		 */

		// PrintWriter writer = new PrintWriter("PrimeSwap.txt", "UTF-8");
		// writer.write(100000 + "\n");
		// for (int i = 100000; i > 0; i--) {
		// writer.print(i + " ");
		//
		// }
		// writer.close();

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m;
		List<Long> list1 = new ArrayList<Long>();
		while (n > 0) {
			m = in.nextInt();
			for (int i = 0; i < m; ++i) {
				long temp = in.nextLong();
				list1.add(temp);
			}
			n--;
		}

		Collections.sort(list1);
		int size = list1.size();
		long x = list1.get(0);
		int count = 1;
		for (int i = 1; i < size; ++i) {
			if (list1.get(i) == x) {
				count++;
			} else {
				System.out.println(x + "\t" + count);
				x = list1.get(i);
				count = 1;
			}
		}
		System.out.println(x + "\t" + count);

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
