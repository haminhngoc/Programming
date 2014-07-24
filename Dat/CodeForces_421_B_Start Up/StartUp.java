import java.util.Scanner;

public class StartUp {
	private static Scanner readers = new Scanner(System.in);

	public static void main(String[] args) {
		int[] words = new int[] { 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1,
				0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0 };
		;
		String input;
		input = readers.nextLine();
		if (input.length() == 1)
		{
			int index = (int) (input.charAt(0) - 'A');
			if (words[index] == 0) 
				System.out.print("NO");
			else System.out.print("YES");
		}
		else {
			int i = 0, j = input.length() - 1;
			boolean isFalse = false;
			while (i <= j) {
				if (input.charAt(i) != input.charAt(j)) {
					System.out.print("NO");
					break;
				} else {
					int index = (int) (input.charAt(i) - 'A');
					if (words[index] == 0) {
						System.out.print("NO");
						break;
					}
				}
				i++;
				j--;
			}
			if (i > j)
				System.out.print("YES");
		}
	}

}
