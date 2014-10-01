public class Main21 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; ++i) {
			for (int j = 1; j <= 5; ++j) {
				if (i == j) {
					continue;
				}
				for (int k = 1; k <= 5; ++k) {
					if (k == i || k == j) {
						continue;
					}
					for (int m = 1; m <= 5; ++m) {
						if (k == m || m == i || m == j) {
							continue;
						}
						for (int n = 1; n <= 5; ++n) {
							if (k == n || n == i || n == j || n == m) {
								continue;
							}
							System.out.print(i + "" + j + "" + k + "" + m
									+ "" + n+"    ");
						}
					}
				}
			}
		}

	}
}
