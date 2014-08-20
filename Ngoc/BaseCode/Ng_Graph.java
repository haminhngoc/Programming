import java.util.*;

public class Ng_Graph {
	static boolean test = true;

	// Connected components of undirected graph
	// Can modify to count components or export components detail
	// vertex: 1..nVertext
	static int UG_CC(int nVertex, int[][] edges) {
		final int[] roots = new int[nVertex + 1]; // Omit vertext0

		int count = 0;
		int nEdge = edges.length;

		for (int i = 0; i < nEdge; i++) {
			int v0 = edges[i][0];
			int v1 = edges[i][1];
			if (v0 == v1)
				continue;
			int root0 = findTopRoot(roots, v0);
			int root1 = findTopRoot(roots, v1);
			if (v0 == root1 || v1 == root0)
				continue;
			if (root0 == 0 && root1 > 0) {
				roots[v0] = root1;
				count++;
			} else if (root1 == 0 && root0 > 0) {
				roots[v1] = root0;
				count++;
			} else if (root0 == 0 && root1 == 0) {
				roots[v1] = v0;
				count++;
			} else if (root0 != root1) {
				roots[root1] = root0;
				count++;
			}
		}

		// Export Count Of Each Group
		int[] groupCounts = new int[nVertex + 1];
		for (int i = 1; i <= nVertex; i++) {
			int topRoot = modifyParentToTopRoot(roots, i);
			groupCounts[topRoot]++;
		}

		// Export Items Ordered by Root
		for (int i = 1; i <= nVertex; i++) {
			if (roots[i] == 0) {
				roots[i] = i;
			}
		}
		Integer[] groupOrders = new Integer[nVertex + 1];
		for (int i = 1; i <= nVertex; i++) {
			groupOrders[i] = i;
		}
		Arrays.sort(groupOrders, new Comparator<Integer>() {
			@Override
			public int compare(Integer arg0, Integer arg1) {
				return Integer.compare(roots[arg0], roots[arg1]);
			}
		});

		return count;
	}

	// Find top root of vertex
	static int findTopRoot(int[] roots, int vertex) {
		int root = roots[vertex];
		if (root == 0)
			return 0;
		// while (roots[root] > 0 && roots[root] != root) {
		while (roots[root] > 0) {
			root = roots[root];
		}
		return root;
	}

	static int modifyParentToTopRoot(int[] roots, int vertex) {
		int root = roots[vertex];
		if (root == 0)
			return 0;
		// while (roots[root] > 0 && roots[root] != root) {
		while (roots[root] > 0) {
			root = roots[root];
		}
		int parent = vertex;
		while (parent != root) {
			int next = roots[parent];
			roots[parent] = root;
			parent = next;
		}
		return root;
	}

	/*
	 * Connected components of directed graph. Can modify to count components or
	 * export components detail
	 */
	static int DG_CC(int nVertex, int[][] edges) {
		return 0;
	}

	/*
	 * Strongly Connected components of undirected graph Can modify to count
	 * components or export components detail
	 */
	static int UG_S_CC(int nVertex, int[][] edges) {

		return 0;
	}

	/*
	 * Strongly Connected components of directed graph. Can modify to count
	 * components or export components detail
	 */
	static int DG_S_CC(int nVertex, int[][] edges) {

		boolean[] visits = new boolean[nVertex + 1];
		int[] parents = new int[nVertex + 1];

		int nEdge = edges.length;

		for (int i = 0; i < nEdge; i++) {
			int s = edges[i][0];
			int t = edges[i][1];
			// int w = edges[i][2];

			if (visits[s]) {

			} else {

			}
		}

		return 0;
	}

	// Dijkstra with PriorityQueue
	static void dijkstra(int nVertex, int[][] edges, int source,
			int[] distances, int[] parents) {

	}

	// Find vertex with maximum shortest path flow
	static int maxflow_vertex_dijkstra(int nVertex, int[][] edges, int source,
			int[] distances, int[] parents) {
		return 0;
	}

	// Count all shortest path from S to T
	static int path_dijkstra(int nVertex, int[][] edges, int source,
			int[] distances, int[] parents) {
		return 0;
	}

	
	
	
	
	


	static class Edge {
		public int v1;
		public int v2;

		public Edge(int v1, int v2) {

		}
	}
	
	
	
	public static void main(String[] args) {

		System.out.println("---------END----------");
	}

	public static void printTest(Object... obj) {
		if (!test)
			return;
		System.out.print(join(obj, " "));
	}

	public static void printTestLn(Object... obj) {
		if (!test)
			return;
		System.out.println(join(obj, " "));
	}

	public static String join(Object[] objs, String glue) {
		if (objs.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int i;
		for (i = 0; i < objs.length - 1; i++) {
			sb.append(objs[i] + glue);
		}
		return sb.toString() + objs[i];
	}

}
