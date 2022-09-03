import java.util.Arrays;

public class KClosestPoint_GFG {
	static public int[][] kClosest(int[][] pts, int k) {
		int n = pts.length;
		int[] distance = new int[n];
		for(int i = 0; i < n; i++){
			int x = pts[i][0], y = pts[i][1];
			distance[i] = (x * x) + (y * y);
		}

		Arrays.sort(distance);

		// Find the k-th distance
		int distk = distance[k - 1];

		// Print all distances which are
		// smaller than k-th distance
		int[][] result=new int[k][2];
		int index=0;
		for(int i = 0; i < n; i++){
			int x = pts[i][0], y = pts[i][1];
			int dist = (x * x) + (y * y);

			if (dist <= distk){
				System.out.println("[" + x + ", " + y + "]");
				result[index++]=new int[]{x,y};
			}
		}
		return result;
	}

	public static void main(String[] args) {
		//int[][] points={{1,3},{-2,2}};
		int[][] points={{3,3},{5,-1},{-2,4}};
		int k = 2;
		//int k=1;
		System.out.println(Arrays.deepToString((kClosest(points,k))));
	}
}