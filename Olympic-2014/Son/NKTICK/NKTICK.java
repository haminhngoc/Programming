import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

public class NKTICK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		int n;
		n = in.nextInt();
		int[] t = new int[n];
		int[] r = new int[n];
		for (int i = 0; i < n; i++)
			t[i] = in.nextInt();
		for(int i=0;i<n-1;i++)
			r[i] = in.nextInt();
		int []sum= new int[n];
		sum[0]=t[0];
		sum[1]=Math.min(t[0]+t[1],r[0]);
		for(int i=2;i<n;i++)
		{
			sum[i]=Math.min(sum[i-2]+r[i-1],sum[i-1]+t[i]);
		}
		System.out.println(sum[n-1]);

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

}


