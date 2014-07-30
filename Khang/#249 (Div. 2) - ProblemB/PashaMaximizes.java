import java.util.*;

public class PashaMaximizes {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		long a = reader.nextLong(); // 10^18
		int k = reader.nextInt();
		String tmp = new Long(a).toString();
		char[] array = tmp.toCharArray();
		int length = array.length;
		int last = 0;
		int first = 0;
		int max = 0;
		// Start
		float startTime = System.currentTimeMillis();
		while (k > 0) {
			max = first;
			last = first + k < length ? first + k : length - 1;
			//System.out.println("f: " + first + " l: " + last + " k: " + k);
			for (int i = first + 1; i <= last; i++) {
				if ((int) array[i] > (int) array[max]) {
					max = i;
				}
			}
			if (max > first) {
				Swap(array, first, max);
				k -= max - first;
				if (first - k > 0) {
					first -= k;
					max = first;
				} else {
					first = 0;
					max = 0;
				}
			} else if (first == length) {
				break;
			} else {
				first++;
			}
			

		}
		// End
		float estimatedTime = System.currentTimeMillis() - startTime;
		//System.out.println(estimatedTime);
		//System.out.println(new String("k:" + k));
		System.out.println(new String(array));
	}

	private static void Swap(char[] array, int first, int last) {
		char tmp;
		while (last > first) {
			tmp = array[last];
			array[last] = array[last - 1];
			array[last - 1] = tmp;
			last--;
		}
	}

}
