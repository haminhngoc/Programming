import java.util.Scanner;

public class IQTest {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		final int NLINE = 4;
		final int EDGE = 1;
		String[] input = new String[NLINE];
		for (int i = 0; i < NLINE; i++) {
			input[i] = reader.nextLine().trim();
		}

		for (int i = 0; i < NLINE - 1; i++) {
			for (int j = 0; j < NLINE - 1; j++) {
				int nBlack = 0, nWhite = 0;
				for (int y = i; y <= i + EDGE; y++) {
					for (int x = j; x <= j + EDGE; x++) {						
						if (input[y].charAt(x) == '#')
							nBlack++;
						else
							nWhite++;
					}
				}
				
				if (nBlack >= (EDGE*4 -1) || nWhite >= (EDGE*4 -1))
				{
					System.out.println("YES");
					return ;
				}
			}
		}
		System.out.println("NO");
	}
}
