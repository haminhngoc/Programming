import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		char s[] = in.next().toCharArray();

		PriorityQueue q[] = new PriorityQueue[30];
		for (int i = 0; i < 30; ++i) {
			q[i] = new PriorityQueue<Integer>();
		}
		int l = s.length;
		int con = 'a';
		for (int i = 0; i < l; ++i) {
			q[s[i] - con].add(-i);
		}

		// PriorityQueue<Integer> re = new PriorityQueue<Integer>();

		int last = l;
		int f = -1;

		boolean check[] = new boolean[l];
		for (int i = 0; i < l; ++i) {
			int z = s[i] - con;
			int temp = (int) q[z].poll();
			if (temp == i) {
				//last = i
			} else if (temp < i) {
				continue;
			} else {

			}
		}

	}

}