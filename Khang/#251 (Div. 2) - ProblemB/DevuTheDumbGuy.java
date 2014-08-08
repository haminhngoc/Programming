import java.io.*;
import java.util.*;

public class DevuTheDumbGuy {

	private static final int MAX = (int)1e6;
	//private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader reader = new InputReader(inputStream);		
		long n = reader.nextLong(); // 10^5
		long x = reader.nextLong(); // 10^5
		long minimum = 0;
		MaxHeap maxHeap = new MaxHeap();
		for (int i = 0; i < n; i++) {
			maxHeap.Push(reader.nextInt());
		}
		int[] c = maxHeap.toArray();
		int index = 0;
		while (n > 0) {
			minimum += c[index] * x;
			index++;
			n--;
			if (x > 1)
				x--;
		}
		System.out.println(minimum);
	}

	public static class MaxHeap {
		int Size;
		int[] values;

		public MaxHeap() {
			this.Size = 0;
			values = new int[MAX];
		}

		public int Pop() {
			if (Size > 0) {
				Swap(Size - 1, 0);
				int popedValue = values[Size - 1];
				values[Size - 1] = 0;
				Size--;
				DownHeap(0);
				return popedValue;
			}
			return 0;
		}

		public int GetMax() {
			if (Size > 0)
				return values[0];
			return 0;
		}

		public void Show() {
			for (int i = 0; i < Size; i++) {
				System.out.print(values[i] + " ");
			}
		}

		public void Push(int value) {
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
			int tmp = values[indexA];
			values[indexA] = values[indexB];
			values[indexB] = tmp;
		}

		private int[] toArray() {
			int[] array = new int[Size];
			for (int i = Size - 1; i >= 0; i--) {
				array[i] = Pop();
			}
			return array;
		}
	}

	private static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;

		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
