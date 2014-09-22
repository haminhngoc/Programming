import java.util.Scanner;
import java.util.Vector;


public class DZYLovesSequences {
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
			if (input[i] > input[i - 1]) 
			{
				if (i != n - 1)
					lenght += 1;
				else if (i == n - 1) 
				{
					lenght = i - start + 1;
					process temp = new process();
					temp.process(start, i, lenght);
					arrayVector.add(temp);
				}
			} 
			else {
				lenght = i - start;
				process temp = new process();
				temp.process(start, i - 1, lenght);
				arrayVector.add(temp);

				lenght = 1;
				start = i;
				if (i == n - 1) 
				{
					lenght = 1;
					process temp1 = new process();
					temp1.process(start, start, 1);
					arrayVector.add(temp);
				}
			}
		}
		
		int maxLenght = 0;
		for (int i = 0; i < arrayVector.size(); i++) 
		{
			process a = (process) arrayVector.get(i);
			System.out.print(a.start+"  "+a.end+"  "+a.lenght+"\n");
			//process b = (process) arrayVector.get(i);
			//System.out.print(a.start+"  "+a.end+"  "+a.lenght+"\n");
			//System.out.print(b.start+"  "+b.end+"  "+b.lenght+"\n");
		/*	if(a.lenght==1 || b.lenght==1)
			{ 
				if (a.lenght+b.lenght>maxLenght) 
						maxLenght = a.lenght + b.lenght;
			}
			else if (input[a.end] + 1 < input[b.start + 1]) 
			{
				if (a.lenght + b.lenght > maxLenght)
					maxLenght = a.lenght + b.lenght;
			}*/
		}
		System.out.print(maxLenght);
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
