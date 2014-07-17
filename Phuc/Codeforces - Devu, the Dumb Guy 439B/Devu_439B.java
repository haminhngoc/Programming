
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class Devu_439B {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		long n = in.nextLong();

		long x = in.nextLong();

		List<Integer> numOfChapters = new ArrayList<Integer>();
		int temp;
		for (int i = 0; i < n; ++i) {
			//numOfChapters[i] = in.nextLong();
			temp = in.nextInt();
			numOfChapters.add(temp);
		}
		
		Collections.sort(numOfChapters);

		long sum = 0;
		for (int i = 0; i < n; ++i) {
			sum += numOfChapters.get(i) * x;
			if (x > 1) {
				x--;
			}
		}

		System.out.println(sum);

	}
}
