import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;
import java.nio.file.FileSystem;

import javax.imageio.stream.FileImageInputStream;

public class Main {
	static boolean OLP = false;

	public static void main(String[] args) throws FileNotFoundException {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		if (OLP) {
			inputStream = new FileInputStream("D:\\input.txt");
			outputStream = new FileOutputStream("D:\\output.txt");
		}
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskSPOJ solver = new TaskSPOJ();
		solver.solve(in, out);
		out.close();
	}
}

class TaskSPOJ {
	public void solve(InputReader in, PrintWriter out) {
		Scanner sc = new Scanner(System.in);
		char[] c = sc.nextLine().toCharArray();
		int n = c.length;
		char[] q = sc.nextLine().toCharArray();
		char x = q[0];
		char y = q[1];
		
		long[] cnt = new long[224];
		for(int i = 0; i < n; ++i){
			++cnt[c[i] - 32];
		}
		long res = 0;
		for(int i = 0; i < n; ++i){
			if(c[i] == y){
				--cnt[y - 32];
			}
			if(c[i] == x){
				res += cnt[y - 32]; 
			}
		}
		out.println(res);
	}
}

class InputReader {
	public BufferedReader reader;
	public StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream), 32768);
		tokenizer = null;
	}

	public InputReader(FileInputStream stream) {
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
