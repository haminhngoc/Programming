import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		int x3 = in.nextInt();
		int y3 = in.nextInt();
		if (x1 == x2) {
			if (y1 == y3) {
				System.out.println(x3 + " " + y2);
			} else if (y2 == y3) {
				System.out.println(x3 + " " + y1);
			}
		} else if (x2 == x3) {
			if (y1 == y3) {
				System.out.println(x1 + " " + y2);
			} else if (y2 == y1) {
				System.out.println(x1 + " " + y3);
			}
		} else if (x3 == x1) {
			if (y2 == y3) {
				System.out.println(x2 + " " + y1);
			} else if (y2 == y1) {
				System.out.println(x2+ " " + y3);
			}
		}
	}

}
