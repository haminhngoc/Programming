import java.util.Scanner;
import java.util.Vector;

public class A4 {
	private static Scanner readers = new Scanner(System.in);

	public static void main(String[] args) {
		int n = 0;
		n = readers.nextInt();
		int[] input = new int[n];
		int start, lenght = 1;
		Vector arrayVector = new Vector();

		for (int i = 0; i < n; i++) {
			input[i] = readers.nextInt();
		}

		start = 0;
		for (int i = 1; i < n; i++) {
			if (input[i] >= input[i - 1]) {
				lenght += 1;
			} else {
				lenght = i - start;
				process temp = new process();
				temp.process(start, i - 1, lenght);
				arrayVector.add(temp);

				lenght = 1;
				start = i;
			}
		}
		lenght = n - start;
		process temp = new process();
		temp.process(start, n - 1, lenght);
		arrayVector.add(temp);

		int maxLenght = 0;
		for (int i = 0; i < arrayVector.size()-1; i++) {
			process a = (process) arrayVector.get(i);
			process b = (process) arrayVector.get(i + 1);
			if (input[a.start + a.lenght] < input[b.start + 1]
					|| input[a.start + a.lenght - 1] < input[b.start]) {
				if (maxLenght < a.lenght + b.lenght) {
					maxLenght = a.lenght + b.lenght;
					start = a.start;
				}
			}
		}
		System.out.print(start+"  "+maxLenght);
	}

}

class process {
	int start;
	int end;
	int lenght;

	public void process(int _start, int _end, int _lenght) {
		start = _start;
		end = _end;
		lenght = _lenght;
	}
}
