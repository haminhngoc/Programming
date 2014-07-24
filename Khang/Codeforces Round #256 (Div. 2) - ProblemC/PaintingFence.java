import java.util.*;

public class PaintingFence {

	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		int n = reader.nextInt(); // 5000
		long[] fencePlanks = new long[n]; // 10^9
		for (int i = 0; i < n; i++) {
			fencePlanks[i] = reader.nextLong();
		}
		int step = 0;
		int remain = n;
		long previous = n;
		while (n > 0) {
			step++;
			remain -= PaintAHorizontalBrush(fencePlanks, n,
					GetOptimalIndex(fencePlanks, n, n - step));
			if (remain + step < previous)
				previous = remain + step;

			// STOP HERE
			if (remain == 0 || (step == n && remain > 0))
				break;
		}
		System.out.println(previous);
	}

	private static int PaintAHorizontalBrush(long[] array, int n, int start) {
		int nDone = 0;
		while (start < n) {
			if (array[start] > 0) {
				array[start]--;
				if (array[start] == 0)
					nDone++;
			} else
				break;
			start++;
		}
		return nDone;
	}

	// Test Graph
	private static int GetOptimalIndex(long[] array, int n, int limit) {
		int start = 0;
		long count = 0;
		Boolean isCounting = false;
		long[][] label = new long[2][n];
		for (int i = 0; i < n; i++) {
			if (array[i] > 0) {
				if (count == 0) {
					isCounting = true;
					start = i;
				}
				if (isCounting) {
					count++;
					label[1][start] += array[i] > limit ? limit : array[i];
				}
			} else if (count > 0) {
				label[0][start] = count;
				count = 0;
				isCounting = false;
			}
			if (i == n - 1) {
				label[0][start] = count;
			}
		}
		// /
		int optimalIndex = 0;
		for (int i = 0; i < n; i++) {
			if (label[0][i] == 0)
				continue;
			if (label[0][optimalIndex] == 0) {
				optimalIndex = i;
			} else if ((limit * label[0][i] - label[1][i]) > (limit
					* label[0][optimalIndex] - label[1][optimalIndex])) {
				optimalIndex = i;
			}
		}
		return optimalIndex;
	}	
}
