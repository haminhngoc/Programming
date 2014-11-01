import java.util.*;

public class Main {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		ExecuteG();
		// ExecuteC();
		// ExecuteD();
		// ExecuteE();
		reader.close();
	}

	private static void ExecuteE() {
		// TODO Auto-generated method stub
		String a = reader.next();
		if (solveE(a) == true)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	private static boolean solveE(String a) {
		// TODO Auto-generated method stub
		if (a.compareTo("") == 0)
			return true;
		StringBuilder sB = new StringBuilder();
		char sA[] = a.toCharArray();
		int n = a.length();
		int i = 0;
		while (i < n) {
			if (i == n - 1) {
				sB.append(sA[i]);
				i++;
			} else {
				if (sA[i] == sA[i + 1]) {
					sB.append(sA[i]);
					i++;
				} else {
					i += 2;
				}
			}
		}
		// System.out.println(sB.toString());
		if (sB.length() != a.length())
			return solveE(sB.toString());
		if (sB.length() == a.length())
			return false;
		return true;
	}

	private static void ExecuteD() {
		int n;
		n = reader.nextInt();
		int[] colors = new int[n];
		int[] solders = new int[n];
		for (int i = 0; i < n; i++) {
			solders[i] = reader.nextInt();
			colors[solders[i]]++;
		}
		int times;
		times = reader.nextInt();
		int solder;
		int color;
		int tmp = 0;
		for (int i = 0; i < times; i++) {
			solder = reader.nextInt();
			color = reader.nextInt();
			if (color != solders[solder]) {
				colors[color]++;
				colors[solders[solder]]--;
				solders[solder] = color;
				if (colors[color] == n) {
					System.out.println(i + 1);
					tmp = 1;
					break;

				}
			}
		}
		if (tmp == 0)
			System.out.println(-1);
	}

	private static void ExecuteC() {
		// TODO Auto-generated method stub
		long k = reader.nextInt();
		long a = k + 1;
		long b = (a * k) / (a - k);
		int r = 0;
		long arrA[] = new long[1000];
		long arrB[] = new long[1000];
		while (a <= 2 * k) {
			if (a * b == k * (a + b)) {
				if (a != b) {
					arrA[r] = a;
					arrB[r] = b;
					r++;
					arrA[r] = b;
					arrB[r] = a;
					r++;
				} else {
					arrA[r] = a;
					arrB[r] = a;
					r++;
				}
			}
			a++;
			b = a * k / (a - k);
		}
		System.out.println(r);
		for (int i = 0; i < r; i++)
			System.out.println(arrA[i] + " " + arrB[i]);
	}

	private static void ExecuteG() {
		int n = reader.nextInt();
		long sum = reader.nextInt();
		long[] values = new long[n + 1];
		values[0] = 1;
		int end = 0;
		long[] tmp = new long[n];
		for (int i = 0; i < n; i++) {
			tmp[i] = reader.nextInt();
		}
		for (int i = 1; i < (n + 1); i++) {
			if (values[i - 1] * tmp[i -1] > sum) {
				break;
			} else {
				values[i] = values[i - 1] * tmp[i -1];
				end = i;
			}
		}
		int count = 0;
		while (sum > 0) {
			// System.out.println("value" + values[end]);
			if (sum >= values[end]) {
				count += sum / values[end];
				sum %= values[end];
			}
			end--;
		}
		System.out.println(count);
	}
}