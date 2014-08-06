import java.util.*;

public class KuriyamaMiraiStones {
	private static Scanner reader = new Scanner(System.in);
	private static final int MAX = 1000000;
	public static void main(String[] args) {
		int n = reader.nextInt(); // 10^5
		long[] dpV = new long[n]; // 10^9
		long[][] dpU = new long[2][n]; // 10^9
		MaxHeap heap = new MaxHeap();
		long sum = 0;
		for (int j = 0; j < n; j++) {
			dpU[0][j] = reader.nextLong();
			heap.Push(dpU[0][j]);
			sum += dpU[0][j];
			dpV[j] = sum;			
		}		
		for(int i = n - 1; i >= 0; i--)
		{
			dpU[0][i] = heap.Pop();			
		}
		sum = 0;
		for (int j = 0; j < n; j++) {
			sum += dpU[0][j];
			dpU[1][j] = sum;
		}
		
		int m = reader.nextInt(); // 10^5
		long[] results = new long[m];
		int type = 0;
		int l = 0; // 1 <= l <= r <= n
		int r = 0;
		for (int i = 0; i < m; i++) {
			type = reader.nextInt();
			l = reader.nextInt() - 1;
			r = reader.nextInt() - 1;
			if (type == 1) {
				
				results[i] = dpV[n - 1] - (dpV[n - 1] - dpV[r]);
				if (l > 0)
					results[i] -= dpV[l - 1];
			} else {
				results[i] = dpU[1][n - 1] - (dpU[1][n - 1] - dpU[1][r]);
				if (l > 0)
					results[i] -= dpU[1][l - 1];
			}
		}		
		for (long item : results) {
			System.out.println(item);
		}		
	}
		
	public static class MaxHeap {
		int Size;
		long[] values;

		public MaxHeap() {
			this.Size = 0;
			values = new long[MAX];
		}

		public long Pop() {
			if (Size > 0) {
				Swap(Size - 1, 0);
				long popedValue = values[Size - 1];
				values[Size - 1] = 0;
				Size--;
				DownHeap(0);
				return popedValue;
			}
			return 0;
		}

		public long GetMax() {
			if (Size > 0)
				return values[0];
			return 0;
		}

		public void Show() {
			for (int i = 0; i < Size; i++) {
				System.out.print(values[i] + " ");
			}
		}

		public void Push(long value) {
			this.Size++;
			values[Size - 1] = value;
			if (this.Size > 1)
				UpHeap(Size - 1);
		}

		private void UpHeap(int currIndex) {
			if (currIndex == 0)
				return;
			int parent = (currIndex - 1) / 2;
			if (values[currIndex] > values[parent]) {
				Swap(currIndex, parent);
				UpHeap(parent);
			}
		}

		private void DownHeap(int currIndex) {
			if (Size == 0)
				return;
			if (currIndex * 2 < Size - 1) {
				int greatestChild = values[currIndex * 2 + 1] > values[currIndex * 2 + 2] ? currIndex * 2 + 1
						: currIndex * 2 + 2;
				if (values[currIndex] < values[greatestChild]) {
					Swap(currIndex, greatestChild);
					DownHeap(greatestChild);
				}
			}
			return;
		}

		private void Swap(int indexA, int indexB) {
			long tmp = values[indexA];
			values[indexA] = values[indexB];
			values[indexB] = tmp;
		}
	}
}
