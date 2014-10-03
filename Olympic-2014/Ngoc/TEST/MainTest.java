import java.io.CharConversionException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;
import java.util.RandomAccess;
import java.util.StringTokenizer;
import java.io.InputStream;

public class MainTest {
	public static void main(String[] args) {

		if (false) {
			// For VOSSEVEN
			int n = 1000000;

			StringBuilder text = new StringBuilder();
			Random rand = new Random();
			for (int i = 0; i < n; i++) {
				text.append(rand.nextInt(10));
			}

			System.out.println(text.toString());
		}
	}
}
