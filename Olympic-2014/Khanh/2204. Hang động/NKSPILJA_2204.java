import java.util.Scanner;

class node {
	public float x = 0;
	public float y = 0;

	public node(float _x, float _y) {
		x = _x;
		y = _y;
	}
}

class NKSPILJA_2204 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		node Node[] = new node[n];
		for (int iN = 0; iN < n; iN++) {
			Node[iN] = new node(scan.nextFloat(), scan.nextFloat());
			// Node[iN].x = scan.nextFloat();
			// Node[iN].y = scan.nextFloat();
		}
		node preMax = new node(Node[0].x, Node[0].y);
		node Max = new node(Node[1].x, Node[1].y);

		for (int i = 2; i < n; i++) {
			if (Check(Max, Node[i], Node[i - 1]) == false) {
				if (Node[i - 1].y > Max.y) {
					Max = Node[i - 1];
					preMax = Node[i - 2];
				} else {
					// preMax, Max, Node[i - 1], Node[i]
					node A = preMax, B = Max, C = Node[i - 1], D = Node[i];
					preMax = B;
					float below = (C.y - D.y) / (C.x - D.x)
							- ((A.y - B.y) / (A.x - B.x));
					float above = (C.y - D.y) * C.x / (C.x - D.x) - C.y
							- ((A.y - B.y) * A.x / (A.x - B.x) - A.y);
					Max.x = above / below;
					Max.y = ((A.y - B.y) / (A.x - B.x)) * Max.x
							- ((A.y - B.y) * A.x / (A.x - B.x) - A.y);
				}
			}
		}
		System.out.println(Max.y);
		scan.close();
	}

	private static boolean Check(node nodeA, node nodeB, node nodeC) {
		// TODO Auto-generated method stub
		float y = (nodeA.y - nodeB.y) * (nodeC.x - nodeA.x)
				/ (nodeA.x - nodeB.x) + nodeA.y;
		if (y < nodeC.y)
			return false;
		return true;
	}

}
