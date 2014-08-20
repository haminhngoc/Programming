import java.util.Scanner;

public class KitaharaHarukiGift {
	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt(); // 100
		int app1 = 0, app2 = 0;
		String result = "";
		for (int i = 0; i < n; i++) {
			if (reader.nextInt() == 100)
				app1++;
			else
				app2++;
		}
		if (app1 > 0) {
			result = app1 % 2 == 0 ? "YES" : "NO";
		} else {
			result = app2 % 2 == 0 ? "YES" : "NO";
		}
		System.out.println(result);
	}

}
