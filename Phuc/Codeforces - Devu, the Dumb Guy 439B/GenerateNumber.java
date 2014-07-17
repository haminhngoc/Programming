import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GenerateNumber {
	public static void main(String[] args) {

		random(50000);
	}

	public static long[] random(int number) {
		long[] result = new long[number];
		Random rand = new Random();
		for (int i = 0; i < number; ++i) {
			result[i] = Math.abs((rand.nextLong() % 50000));
		}
		return result;
	}
}
