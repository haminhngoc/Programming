import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

class Main {
	public static void main(String[] args) {
		TaskInterval solver = new TaskInterval();
		solver.solve();
	}
}

class TaskInterval {
	public void solve() {
		Input(System.in);
		String s;
		int[] a;
		IntervalProduct tree;
		String line;
		try {
			while ((line = reader.readLine()) != null) {
				String[] tmp = line.split(" ");
				int n = Integer.parseInt(tmp[0]);
				int q = Integer.parseInt(tmp[1]);
				tmp = reader.readLine().split(" ");
				a = new int[n + 1];
				for (int i = 1; i <= n; i++) {
					a[i] = Integer.parseInt(tmp[i - 1]);
				}
				tree = new IntervalProduct(n, a);
				int u, v;
				while (q-- > 0) {
					tmp = reader.readLine().split(" ");
					s = tmp[0];
					u = Integer.parseInt(tmp[1]);
					v = Integer.parseInt(tmp[2]);
					if (s.equals("P")) {
						System.out.print(tree.product(u, v));
					} else {
						tree.update(u, v);
					}
				}
				System.out.println();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public BufferedReader reader;

	public void Input(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
	}
}

class IntervalProduct {
	int[] array;
	int[] st;
	int[] stn;
	int cntZero;
	int cntNegative;
	int n;

	IntervalProduct(int n, int[] a) {
		this.n = n;
		this.array = a;
		st = new int[4 * n + 1];
		stn = new int[4 * n + 1];
		build(1, 1, n);
	}

	void build(int node, int left, int right) {
		if (left == right) {
			if (array[left] == 0)
				st[node] = 1;
			if (array[left] < 0)
				stn[node] = 1;
			return;
		}
		int mid = (left + right) / 2;
		build(node * 2, left, mid);
		build(node * 2 + 1, mid + 1, right);

		st[node] = st[node * 2] + st[node * 2 + 1];
		stn[node] = stn[node * 2] + stn[node * 2 + 1];
	}

	String product(int i, int j) {
		cntZero = cntNegative = 0;
		interalProduct(1, i, j, 1, n);
		if (cntZero != 0)
			return "0";
		if (cntNegative % 2 == 0)
			return "+";
		return "-";
	}

	void interalProduct(int node, int i, int j, int left, int right) {
		if (j < left || i > right)
			return;
		if (i <= left && right <= j) {
			cntZero += st[node];
			cntNegative += stn[node];
		} else {
			int mid = (left + right) / 2;
			interalProduct(node * 2, i, j, left, mid);
			interalProduct(node * 2 + 1, i, j, mid + 1, right);
		}
	}

	void update(int index, int newValue) {
		internalUpdate(1, index, newValue, 1, n);
	}

	void internalUpdate(int node, int index, int newValue, int left, int right) {
		if (index < left || index > right)
			return;
		if (left == right) {
			if (array[index] == 0)
				st[node]--;
			if (array[index] < 0)
				stn[node]--;
			if (newValue == 0)
				st[node]++;
			if (newValue < 0)
				stn[node]++;
			array[index] = newValue;
			return;
		}
		int mid = (left + right) / 2;
		internalUpdate(node * 2, index, newValue, left, mid);
		internalUpdate(node * 2 + 1, index, newValue, mid + 1, right);

		st[node] = st[node * 2] + st[node * 2 + 1];
		stn[node] = stn[node * 2] + stn[node * 2 + 1];
	}
}
