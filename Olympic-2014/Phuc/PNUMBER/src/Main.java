import java.util.ArrayList;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int A = in.nextInt();
		int B = in.nextInt();

		List<Integer> list = new ArrayList<Integer>();

		list.add(2);
		list.add(3);
		int size = 2;
		StringBuilder re = new StringBuilder();
		if (2 >= A&&2<=B) {
			re.append(2 + "\n");
		}
		if (3 >= A&&3<=B) {
			re.append(3 + "\n");
		}

		for (int i = 5; i <= B; i += 2) {
			int end = (int) Math.sqrt(i);

			int j = 0;

			while (j < size && list.get(j) <= end) {
				if (i % list.get(j) == 0) {
					break;
				}
				j++;
			}
			if (j < size && list.get(j) <= end) {
				continue;
			}

			list.add(i);
			size++;
			if (i >= A) {
				re.append(i + "\n");
			}
		}
		System.out.println(re);

	}

}
