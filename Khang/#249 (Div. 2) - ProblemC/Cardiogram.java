import java.io.*;
import java.util.*;

public class Cardiogram {

	private static Scanner reader = new Scanner(System.in);
	private static OutputStream reader2 = new BufferedOutputStream(System.out);

	public static void main(String[] args) throws IOException {
		int n = reader.nextInt(); // 1000
		int[] a = ReadIntArray(n);
		int[][] label = new int[3][n];
		//long startTime = System.currentTimeMillis();
		int sum = 0;
		int min = 0;
		int max = 0;
		int current = 0;
		int direct = 1;
		for (int item : a) {
			sum += item;
			current += item * direct;
			if (current < min)
				min = current;
			if (current > max)
				max = current;
			direct *= -1;
		}
		int height = max - min;
		StringBuilder[] lines = new StringBuilder[height];
		for (int i = 0; i < height; i++) {
			lines[i] = new StringBuilder();
			for (int j = 0; j < sum; j++) {
				lines[i].append(" ");
			}
		}
		direct = -1;
		current = 0;
		for (int j = 0; j < n; j++) {
			direct *= -1;
			label[0][j] = a[j];
			label[1][j] = direct > 0 ? max - (current + 1) : max - current;
			current += a[j] * direct;
			label[2][j] = direct;
		}
		int y = 0;
		int start = 0;
		int need = 0;
		String brush = new String();
		for (int i = 0; i < n; i++) {
			start = label[1][i];
			need = label[0][i];
			while (need > 0) {
				brush = label[2][i] == 1 ? "/" : "\\";
				lines[start].replace(y, y + 1, brush);
				y++;
				need--;
				start += -1 * label[2][i];
			}
		}
		for (int i = 0; i < height; i++) {
			System.out.println(lines[i].toString());
		}
		// long estimatedTime = System.currentTimeMillis() - startTime;
		// System.out.println(estimatedTime);
	}

	// UTILITY METHODS
	private static int[] ReadIntArray(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = reader.nextInt();
		}
		return array;
	}
}
