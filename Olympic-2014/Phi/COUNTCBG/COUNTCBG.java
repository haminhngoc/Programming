import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		COUNTCBG solver = new COUNTCBG();
		solver.solve(in, out);
		out.close();
	}
}

class COUNTCBG {
    public void solve(InputReader in, PrintWriter out) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int n = Integer.parseInt(sc.nextLine());
            int c;
            int res = 0;
            for(int i = 1; i*(i+1)/2 < n; ++i){
                c = i*(i+1)/2;
                if((n-c) % (i+1) == 0){
                    ++res;
                }
            }
            out.println(res);
        }
    }
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream), 32768);
        tokenizer = null;
    }

}

