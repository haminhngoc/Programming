import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String s = in.nextLine();
		StringBuilder str = new StringBuilder();
		while (s.compareTo("[END]") != 0) {
			int n = in.nextInt();
			int mode = n % 5;
			if (mode == 1 || mode == 3 || mode == 4) {
				str.append("Taro\n");
			}else{
				str.append("Hanako\n");
			}
			s = in.next();
		}
		
		System.out.println(str);
	}
}
