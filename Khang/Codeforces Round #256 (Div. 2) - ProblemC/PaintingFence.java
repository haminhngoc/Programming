import java.util.*;

public class PaintingFence {

	private static final long MAX = 1000000000;
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
			// /
			// int test = GetOptimalIndex(fencePlanks, n);
			// System.out.println("Optimal Index: " + test);
			remain -= Decrease(fencePlanks, n,
					GetOptimalIndex(fencePlanks, n, n - step));
			if (remain + step < previous)
				previous = remain + step;

			// for (int i = 0; i < n; i++) {
			// System.out.print(fencePlanks[i] + " ");
			// }
			// System.out.println("solution:" + previous + "  ");

			// STOP HERE
			if (remain == 0 || (step >= n && remain > 0))
				break;
		}
		System.out.println(previous);
	}

	private static int Decrease(long[] array, int n, int start) {
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
		long sumHeight = 0;
		long count = 0;
		int nDone = 0;
		Boolean isCounting = false;
		long[][] label = new long[2][n];
		for (int i = 0; i < n; i++) {
			if (array[i] > 0) {
				if (sumHeight == 0) {
					isCounting = true;
					start = i;
				}
				if (isCounting) {
					if (array[i] == 1)
						nDone++;
					sumHeight += array[i];
					count++;
				}
			} else if (sumHeight > 0) {
				label[0][start] = nDone;				
				label[1][start] = count;
				nDone = 0;
				sumHeight = 0;
				count = 0;
				isCounting = false;
			}
			if (i == n - 1) {
				label[0][start] = nDone;				
				label[1][start] = count;
			}
		}		

		// /
		int optimalIndex = 0;
		for (int i = 0; i < n; i++) {
			if (label[1][i] == 0)
				continue;
			if (label[1][optimalIndex] == 0) {
				optimalIndex = i;
			} else if (label[0][i] > label[0][optimalIndex]) {
				optimalIndex = i;
			} else if (ComparePerformance(array, label, i, optimalIndex, limit)) {
				optimalIndex = i;
			}
		}
		return optimalIndex;
	}

	private static Boolean ComparePerformance(long[] array, long label[][],
			int indexA, int indexB, int limit) {
		double nDoneA = 0;
		double nDoneB = 0;
		long minA = MAX;
		long minB = MAX;
		long length = label[1][indexA] > label[1][indexB] ? label[1][indexA]
				: label[1][indexB];
		for (int i = 0; i < length; i++) {
			if (indexA + i < indexA + label[1][indexA]) {
				if (array[indexA + i] < minA)
					minA = array[indexA + i];
			}
			if (indexB + i < indexB + label[1][indexB]) {
				if (array[indexB + i] < minB)
					minB = array[indexB + i];
			}
		}
		if (minA >= limit)
			return false;

		for (int i = 0; i < length; i++) {
			if (indexA + i < indexA + label[1][indexA]) {
				if (array[indexA + i] == minA)
					nDoneA++;
			}
			if (indexB + i < indexB + label[1][indexB]) {
				if (array[indexB + i] == minB)
					nDoneB++;
			}
		}
		if ((nDoneA / minA) + ((label[1][indexA] - nDoneA) * minA) > (nDoneB / minB)
				+ ((label[1][indexB] - nDoneB) * minB)) {
			return true;
		}
		return false;
	}
}
