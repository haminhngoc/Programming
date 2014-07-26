import java.util.*;

public class JzzhuAndChildren {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt(); // 100
		int m = reader.nextInt(); // 100
		int last = 0;
		Queue<Child> line = new LinkedList<Child>();
		for (int i = 0; i < n; i++) {
			line.add(new Child(i + 1, reader.nextInt()));
		}
		do {
			if (line.peek().nCandies <= m) {
				last = line.poll().order;
			} else {
				Child child = line.poll();
				child.nCandies -= m;
				line.add(child);
			}
		} while (!line.isEmpty());
		System.out.println(last);
	}

	public static class Child {
		int order = 0;
		int nCandies = 0;

		public Child(int _order, int _nCandies) {
			order = _order;
			nCandies = _nCandies;
		}
	}

}
