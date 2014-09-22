import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

class Main {

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
    	Scanner ii  = new Scanner(System.in);     
       while(ii.hasNextInt())
       {
    	   int a = ii.nextInt();
    	   if(check(a))
    	   {
    		   System.out.println("Y");
    	   }
    	   else
    	   {
    		   System.out.println("N");
    	   }
       }
    }

	private boolean check(int a) {
		for (int i = 0; i < 60; i++) {
			for (int j = 0; j < 60; j++) {
				if(j%12 == 0)
				{
					i++;
				}
				if((j-i)*6 == a)
				{
					return true;
				}
				
			}
		}
		return false;
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
