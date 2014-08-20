import java.util.*;

public class TarjanAlgorithm {
	private static Scanner readers = new Scanner(System.in);
	
	private static List<List<Integer>> TarjanSearch(List<Integer>[] graph){
		List<List<Integer>> result = new ArrayList();
		int lenghtGraph = graph.length;
		boolean [] visited = new boolean[lenghtGraph];
		int [] root = new int [lenghtGraph];
		for(int i=0;i<lenghtGraph;i++)
		{
			if(visited[i]==false){
				visited[i]=true;
				List<Integer> subGraph = new ArrayList();
				for(int j=0;j<graph[i].size();j++){
					if(visited[graph[i].get(j)]==true)
				}
			}
		}
		return new List<List<Integer>>();
	}
	public static void main(String[] args) {
		boolean[] s= new boolean[2];
System.out.print(s[0]);
	}

}
