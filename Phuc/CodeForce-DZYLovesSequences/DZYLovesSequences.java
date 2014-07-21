import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DZYLovesSequences {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		int last = 0;
		long max = -1;
		int start = 0;
		long startValue = -1;
		List<Temp> list = new ArrayList<Temp>();
		long[] arr = new long[(int) n];
		for (int i = 0; i < n; ++i) {
			long t = in.nextLong();
			arr[i] = t;
			if (max < t) {
				last++;

				max = t;
			} else {
				Temp a = new Temp();
				a.start = start;
				a.end = i - 1;
				a.last = last;
				max = t;
				startValue = -1;
				last = 1;
				start = i;
				list.add(a);
			}
		}
		Temp a = new Temp();
		a.start = start;
		a.end = (int) (n - 1);
		a.last = last;
		list.add(a);
		int count = list.size();
		int maxLength = list.get(0).last + 1;
		for (int i = 1; i < count; ++i) {

			Temp a1 = list.get(i - 1);
			Temp a2 = list.get(i);
			if (maxLength < a1.last + a2.last && a1.last + a1.start == a2.start) {

				if (a1.last > 1
						&& arr[a1.last + a1.start - 2] + 1 < arr[a2.start]) {
					maxLength = a1.last + a2.last;
				} else if (a2.last > 1
						&& arr[a1.last + a1.start - 1] + 1 < arr[a2.start + 1]) {
					maxLength = a1.last + a2.last;
				}
			}
			if (maxLength <= a2.last) {
				maxLength = a2.last + 1;
			}

		}
		if (maxLength < list.get(count - 1).last) {
			maxLength = list.get(count - 1).last + 1;
		}
		System.out.println(maxLength > n ? n : maxLength);
	}

	public static class Temp {
		int start;
		int last;
		int end;
		long lastValue;
		long startValue;
	}

}
