import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.TreeSet;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

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
	int[] preOrder;
	int[] inOrder;
	int[] posIn;
	StringBuilder res;
	int index;
	
	public void solve(InputReader in, PrintWriter out) {
		int n = in.nextInt();
		int MAX = (int)1e6;
		
		res = new StringBuilder();
		preOrder = new int[n];
		inOrder = new int[n];
		posIn = new int[MAX];
		
		for(int i = 0; i < n; ++i){
			preOrder[i] = in.nextInt();
		}
		for(int i = 0; i < n; ++i){
			inOrder[i] = in.nextInt();
			posIn[inOrder[i]] = i;
		}
		index = 0;
		Node root = new Node();
		build(root,0,n-1);
		postTravel(root);
		out.println(res);
	}
	
	void build(Node node, int lo, int hi){
		if(lo > hi) return;
		node.value = preOrder[index];
		index++;
		if(lo == hi) return;
		int mid = posIn[node.value];
		if(lo <= mid-1){
			node.leftChild = new Node();
			build(node.leftChild,lo,mid-1);
		}
		if(mid+1 <= hi){
			node.rightChild = new Node();
			build(node.rightChild,mid+1,hi);
		}
	}
	
	void postTravel(Node node){
		if(node.leftChild != null){
			postTravel(node.leftChild);
		}
		if(node.rightChild != null){
			postTravel(node.rightChild);
		}
		res.append(node.value);
		res.append(" ");
	}	
}

class Node{
	Node leftChild;
	Node rightChild;
	int value;
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

	char[][] nm(int n, int m) {
		char[][] map = new char[n][];
		for (int i = 0; i < n; i++)
			map[i] = ns(m);
		return map;
	}

	int[] na(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = nextInt();
		return a;
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

	long nl() {
		long num = 0;
		int b;
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