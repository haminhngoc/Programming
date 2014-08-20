import java.util.*;

public class DevuTheDumbGuy2 {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		long n = reader.nextLong(); // 10^5
		long x = reader.nextLong(); // 10^5
		long minimum = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			list.add(new Integer(reader.nextInt()));
		}
		Collections.sort(list);
		for (int i = 0; i < n; i++) {
			minimum += list.get(i) * x;
			if (x > 1)
				x--;
		}
		System.out.println(minimum);
	}

}
