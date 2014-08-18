import java.util.*;


public class Megacity {
	private static Scanner readers = new Scanner(System.in);
	public static void main(String[] args) {
		int n,s;
		List<Location> locations= new ArrayList<Location>();
		n=readers.nextInt();
		s=readers.nextInt();
		for(int i=0;i<n;i++)
		{
			int x,y,people;
			double radius;
			x=readers.nextInt();
			y=readers.nextInt();
			people=readers.nextInt();
			radius= Math.sqrt(x*x+y*y);
			Location temp= new Location();
			temp.Set(radius, people);
			locations.add(temp);
		}
		Collections.sort(locations, new Comparator<Location>() {
            public int compare(Location p1, Location p2) {
                if (p1.radius == p2.radius) 
                	return 0;
                return p1.radius > p2.radius ? 1 : -1;
            }});
		
		for(int i=0;i<locations.size();i++)
		{
			s+=locations.get(i).population;
			if(s>=1000000){
				System.out.print(locations.get(i).radius);
				break;
			}
		}
		if(s<1000000) System.out.print(-1);
	}

}
class Location{
	double radius;
	int population;
	public void Set(double _radius,int people)
	{
		radius=_radius;
		population=people;
	}
}
