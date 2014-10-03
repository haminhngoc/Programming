package array;
import java.util.*;

public class A4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		int n=input.nextInt();
		int []a=new int [n];
		for(int i=0;i<n;i++)
			a[i]=input.nextInt();
		Vector l=new Vector();
		Vector r=new Vector();
		l.addElement(new Integer(0));
		for(int i=1;i<n;i++)
		{
			if(a[i]<a[i-1])
			{
				r.addElement(new Integer(i-1));
				l.addElement(new Integer(i));	
			}
		}
		r.addElement(new Integer(n-1));
		int max=(int)r.elementAt(0)+1;
		int first=(int)l.elementAt(0),end=(int)r.elementAt(0);
		for(int i=1;i<r.size();i++)
		{
			if((int)l.elementAt(i)!=n-1)
			{
			int tmp=0;
			if((a[(int)l.elementAt(i)+1])>=a[(int)r.elementAt(i-1)])
			{
				tmp=(int)r.elementAt(i)+1-(int)l.elementAt(i-1);
				if(tmp>max)
				{
					first=(int)l.elementAt(i-1);
					end=(int)r.elementAt(i);
					max=tmp;
				}
			}
			else
			{
				if((int)r.elementAt(i)+1-(int)l.elementAt(i)>max)
				{
					max=(int)r.elementAt(i)+1-(int)l.elementAt(i);
					first=(int)l.elementAt(i);
					end=(int)r.elementAt(i);
				}
			}
			}
		}
		System.out.println("elemens: "+ max);
		System.out.println("first: "+(end+1-max));
		System.out.println("end: "+end);
		

	}

}
