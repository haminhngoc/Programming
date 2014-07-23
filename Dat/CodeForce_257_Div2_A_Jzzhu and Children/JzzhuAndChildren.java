import java.util.*;


public class JzzhuAndChildren {
	private static Scanner readers = new Scanner(System.in);
	public static void main(String[] args) {
	int n,m;
	n= readers.nextInt();
	m=readers.nextInt();
	int [] children= new int[n];
	for(int i=0;i<n;i++)
	{
		children[i]=readers.nextInt();
	}
	int ChildrenGoHome=0;
	int index=0;
	while(ChildrenGoHome<=n-2)
	{
		if(children[index]<=m && children[index]>0)
			ChildrenGoHome++;
		children[index]-=m;
		index++;
		if(index==n)index=0;
	}
	for(int i=0;i<n;i++)
		if(children[i]>0){
			System.out.print(i+1);
			break;
		}
	
	}
}
