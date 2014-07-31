import java.util.*;


public class GameWithSticks {
private static Scanner readers = new Scanner(System.in);
	public static void main(String[] args) {
		int n,m;
		n= readers.nextInt();
		m=readers.nextInt();
		boolean isAkshatMove=true;
		while(n>1 && m>1)
		{
			n--;
			m--;
			isAkshatMove=!isAkshatMove;
		}
		if(isAkshatMove) System.out.print("Akshat");
		else System.out.print("Malvika");
	}

}
