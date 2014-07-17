import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GeneratateNumber {
	public static void main(String[] args) {
		
		random(50000);
		

	}
	
	static void random (int number)
	{
		Random rand = new Random();
		for(int i =  0; i<number; ++i){
			System.out.println(Math.abs((rand.nextLong()%50000)));
		}
	}

}
