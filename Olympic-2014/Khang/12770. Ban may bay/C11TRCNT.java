import java.util.*;

class C11TRCNT {

	public static void main(String[] args) {
		C11TRCNTSolver solver = new C11TRCNTSolver();
		solver.solve();
	}

}

class C11TRCNTSolver {

	private static Scanner in = new Scanner(System.in);

	public void solve() {
		int n = in.nextInt();
		ArrayList<APoint> points = new ArrayList<APoint>();
		int[][][] label = new int[n][n][n];
		for (int i = 0; i < n; i++) {
			points.add(new APoint(i + 1, in.nextLong(), in.nextLong()));
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j) {
					for (int k = j + 1; k < n; k++) {
						if (j != k && k != i) {
							int[] tmp = new int[] { i, j, k };
							Arrays.sort(tmp);
							if (label[tmp[0]][tmp[1]][tmp[2]] == 0) {
								if (check(points.get(i), points.get(j),
										points.get(k))) {
									label[tmp[0]][tmp[1]][tmp[2]] = 1;
									sum++;
									points.get(i).increaseDenfense();
								}
							} else {
								points.get(i).increaseDenfense();
							}
						}
					}
				}
			}
		}

		Collections.sort(points, new Comparator<APoint>() {

			public int compare(APoint a, APoint b) {
				if (a.getDefense() < b.getDefense()) {
					return -1;
				} else if (a.getDefense() > b.getDefense()) {
					return 1;
				}
				return 0;
			}
		});
		System.out.println(sum + " " + points.get(0).getId());
	}

	private static boolean check(APoint a, APoint b, APoint c) {
		APoint vector = new APoint(a, b);
		if (vector.x * (c.x - a.x) + vector.y * (c.y - a.y) == 0) {
			return false;
		}
		return true;
	}
}

class APoint {
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	long x;
	long y;
	int defense = 0;

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public void increaseDenfense() {
		this.defense++;
	}

	public long getX() {
		return x;
	}

	public void setX(long x) {
		this.x = x;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}

	public APoint(int id, long x, long y) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public APoint(APoint a, APoint b) {
		this.x = -(b.y - a.y);
		this.y = b.x - a.x;
	}

	@Override
	public String toString() {
		return this.id + " [x=" + x + ", y=" + y + ", defense=" + this.defense
				+ "]";
	}

}