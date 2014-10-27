import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		/*
		 * FileWriter fw = new FileWriter("out.txt"); StringBuilder str = new
		 * StringBuilder(); for(int i =0; i <=100000; ++i){
		 * str.append("dasdaldajj dksajd\n"); } PrintWriter pw = new
		 * PrintWriter("out.txt"); long startTime = System.nanoTime();
		 * 
		 * //pw.write(str.toString()); fw.write(str.toString()); long endTime =
		 * System.nanoTime(); System.out.println(endTime-startTime);
		 */
		InputStream in = System.in;
		InputStream is = new FileInputStream("t..txt");
		PrintWriter w = new PrintWriter("a.txt");
		FileWriter w1 = new FileWriter("a1.txt");
		w.print("dakdkasd");
		w.close();
		
	}
}
