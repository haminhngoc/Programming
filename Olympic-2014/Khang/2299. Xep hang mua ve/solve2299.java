import java.io.*;
import java.util.*;

class solve2299 {

	public static void main(String[] args) {
		InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader reader = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
		int n = reader.nextInt();
		int[] t = new int[n];		
		int[] finish = new int[n];
		ArrayList<Person> people = new ArrayList<Person>();
		
		for (int i = 0; i < n; i++) {
			t[i] = reader.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {			
			people.add(new Person(i, reader.nextInt()));
		}
		Collections.sort(people);
		
		int remain = n;
		int time = 0;
		for (int i = 0; i < n - 1; i++) {
			if (finish[people.get(i).index] != 1) {
				if (finish[people.get(i).index + 1] != 1) {
					if (people.get(i).r < t[people.get(i).index] + t[people.get(i).index + 1]) {				
						time += people.get(i).r;
					} else {
						time += t[people.get(i).index] + t[people.get(i).index + 1];
					}
					finish[people.get(i).index] = 1;
					finish[people.get(i).index + 1] = 1;
					remain -= 2;
				} else {
					remain -= 1;
					time += t[people.get(i).index];
					finish[people.get(i).index] = 1;
				}				
				// System.out.println("time : " + time);
			}
		}
		
		if (remain == 1) {
			remain--;
			time += t[n - 1];			
		}
		// System.out.println("remain : " + remain);
		// System.out.println("time : " + time);
		System.out.println(time);
		// Test		
	}	
}


class Person implements Comparable<Person> {
	int index = 0;
	int r = 0;

	public Person(int index, int r) {
		this.index = index;
		this.r = r;
	}

	public int compareTo(Person arg0) {
		if (this.r > arg0.r) {
			return 1;
		} else if (this.r == arg0.r) {
			return 0;	
		}
		return -1;
	}
}


/*class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
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

}*/