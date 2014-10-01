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
        TaskA solver = new TaskA();
        solver.solve(in, out);
        out.close();
	}
}

class TaskA {

    public void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n+1];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();        
        int temp;
        
        for(int i = 1; i <= n; ++i){
        	a[i] = in.nextInt();
        	if(!map.containsKey(a[i])){
        		map.put(a[i],1);
        	} else {
        		temp = map.get(a[i]);
        		map.put(a[i],temp+1);
        	}
        }
        
        if(map.size() == 1){
        	out.println(0);
        	return;
        }
        
        int pos,color;
        int curColor;
        int m = in.nextInt();
        
        for(int i = 1; i <= m; ++i){
        	pos = in.nextInt();
        	color = in.nextInt();
        	curColor = a[pos];
        	a[pos] = color;
        	if(!map.containsKey(color)){
        		map.put(color, 1);
        		temp = map.get(curColor);
        		if(temp - 1 == 0){
        			map.remove(curColor);
        		} else {
        			map.put(curColor, temp-1);
        		}
        	} else {
        		temp = map.get(color);
        		map.put(color,temp+1);
        		
        		temp = map.get(curColor);
        		if(temp - 1 == 0){
        			map.remove(curColor);
        		} else {
        			map.put(curColor, temp-1);
        		}
        	}
        	if(map.size() == 1){
            	out.println(i);
            	return;
            }
        }
        out.println(-1);
        
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