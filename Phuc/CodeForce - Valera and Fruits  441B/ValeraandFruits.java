import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ValeraandFruits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int v = in.nextInt();
		int a1;
		int b1;
		List<NewObject> list = new ArrayList<NewObject>();
		for (int i = 0; i < n; ++i) {
			a1 = in.nextInt();
			b1 = in.nextInt();
			list.add(new NewObject(a1, b1));
		}

		Collections.sort(list, new Comparator<ValeraandFruits.NewObject>() {
			@Override
			public int compare(NewObject o1, NewObject o2) {
				if (o1.a < o2.a) {
					return -1;

				}
				if (o1.a > o2.a) {
					return 1;

				}
				return 0;
			}
		});
		int maxDay = list.get(n - 1).a + 1;
		int left = v;
		int index = 0;
		long sum = 0;
		for (int day = 1; day <= maxDay; ++day) {
			while (list.get(index).a < day - 1 && index < n) {
				index++;
			}
			while (left > 0 && index < n) {

				if (list.get(index).a == day - 1 || list.get(index).a == day) {
					if (left < list.get(index).b) {
						sum += left;
						list.get(index).b -= left;
						left = v;
						day++;

					} else if (left == list.get(index).b) {
						sum += left;
						list.get(index).b = 0;
						left = v;
						index++;
						day++;
					} else

					{
						sum += list.get(index).b;
						left -= list.get(index).b;
						index++;
					}

				} else if (list.get(index).a > day) {
					left = v;
					day++;
					
				}
				else
				{
					index++;
				}
			}
			if (index >= n || day > maxDay) {
				break;
			}

		}
		System.out.println(sum);

	}

	public static class NewObject {
		public int a;
		public int b;

		NewObject(int x, int y) {
			a = x;
			b = y;
		}
	}

}