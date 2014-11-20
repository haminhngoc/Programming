import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
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
		BKK solver = new BKK();
		solver.solve(in, out);
		out.close();
	}
}

class BKK {
	public void solve(InputReader in, PrintWriter out) {
		int n = in.nextInt();
        int x = in.nextInt();

        Node[] nodes = new Node[n+1];
        nodes[0] = new Node();
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
            nodes[i].parent = i-1;
            nodes[i].child = i+1;
        }
        int u,v;
        int cur = 1;
        for (int i = 0; i < x; i++) {
            u = in.nextInt();
            v = in.nextInt();
            if(nodes[u].child != n+1){
                nodes[nodes[u].child].parent = nodes[u].parent;
                if(nodes[nodes[u].child].parent == 0){
                    cur = nodes[u].child;
                }
            }
            nodes[nodes[u].parent].child = nodes[u].child;
            nodes[u].parent = nodes[v].parent;
            if(nodes[u].parent == 0){
                cur = u;
            }
            nodes[v].parent = u;
            if(nodes[v].parent == 0){
                cur = v;
            }
            nodes[u].child = v;
            nodes[nodes[u].parent].child = u;
        }
        StringBuilder sb  =new StringBuilder();
        while(cur != n+1){
           sb.append(cur);
           sb.append(" ");
            cur = nodes[cur].child;
        }
        out.println(sb);
	}
}

class Node{
    int parent;
    int child;
}

class InputReader {
	InputStream is;
	byte[] inbuf = new byte[1024];
	int lenbuf = 0, ptrbuf = 0;

	public InputReader(InputStream stream) {
		is = stream;
	}

	int readByte() {
		if (lenbuf == -1)
			throw new InputMismatchException();
		if (ptrbuf >= lenbuf) {
			ptrbuf = 0;
			try {
				lenbuf = is.read(inbuf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (lenbuf <= 0)
				return -1;
		}
		return inbuf[ptrbuf++];
	}

	boolean isSpaceChar(int c) {
		return !(c >= 33 && c <= 126);
	}

	int skip() {
		int b;
		while ((b = readByte()) != -1 && isSpaceChar(b))
			;
		return b;
	}

	double nd() {
		return Double.parseDouble(ns());
	}

	char nc() {
		return (char) skip();
	}

	String ns() {
		int b = skip();
		StringBuilder sb = new StringBuilder();
		while (!(isSpaceChar(b))) {
			sb.appendCodePoint(b);
			b = readByte();
		}
		return sb.toString();
	}

	char[] ns(int n) {
		char[] buf = new char[n];
		int b = skip(), p = 0;
		while (p < n && !(isSpaceChar(b))) {
			buf[p++] = (char) b;
			b = readByte();
		}
		return n == p ? buf : Arrays.copyOf(buf, p);
	}

	int nextInt() {
		int num = 0, b;
		boolean minus = false;
		while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
			;
		if (b == '-') {
			minus = true;
			b = readByte();
		}

		while (true) {
			if (b >= '0' && b <= '9') {
				num = num * 10 + (b - '0');
			} else {
				return minus ? -num : num;
			}
			b = readByte();
		}
	}

}

