import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;

public class PashaMaximizes {

    public static void main(String[] args) {

        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(in, out);
        out.close();
    }
}

class TaskB {
    public void solve(InputReader in, PrintWriter out) {
        int k;
        String a;
        a = in.next();
        k = in.nextInt();
        List<Integer> myList = new ArrayList<Integer>();
        int length = a.length();
        for (int i = 0; i < length; i++) {
            myList.add( Character.getNumericValue(a.charAt(i)));
        }
        int n, max = myList.get(0);
        int j = 0, ith,temp, nSwap = 0;
        while (k > 0 && nSwap < length) {
            if (j + k >= length)
            {
                n = length -1;
            }
            else
            {
                n = j + k;
            }
            ith = j;
            max = myList.get(ith);
            for (int i = j; i <= n; i++) {
                if (myList.get(i) > max)
                {
                    max = myList.get(i);
                    ith = i;
                }
            }
            temp = myList.get(ith);
            myList.remove(ith);
            myList.add(j, temp);
            k = k - (ith - j);
            j++;
            nSwap++;
        }
        String result = new String();
        for(int i = 0; i < length; i++)
        {
            result +=  myList.get(i).toString();
        }
        out.print(result);
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

}