import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(in, out);
        out.close();
    }
}

class Task{

    public void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        Person[] ps = new Person[n];
        for(int i =0; i < n; ++i){
        	ps[i] = new Person();
        	ps[i].name = in.next();
        	ps[i].day = in.nextInt();
        	ps[i].month = in.nextInt();
        	ps[i].year = in.nextInt();
        }
        Arrays.sort(ps);
        out.println(ps[n-1].name);
        out.println(ps[0].name);
    }
}

class Person implements Comparable<Person>{
	String name;
	int day;
	int month;
	int year;

	public int compareTo(Person o) {
		if(this.year != o.year) return this.year - o.year;
		if(this.month != o.month) return this.month - o.month;
		return this.day - o.day;
	}
	
}

class InputReader {
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
