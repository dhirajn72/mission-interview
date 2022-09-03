import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {
	static public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		int[][] graph = new int[n][n];
		for(int[] flight : flights){
			graph[flight[0]][flight[1]] = flight[2];
		}
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);// This is always sort the prices on ascending order.
		q.offer(new int[]{0, src, k + 1});

		while(! q.isEmpty()){
			int[] flight = q.poll();
			int price = flight[0], place = flight[1], kLeft = flight[2];

			if(place == dst)
				return price;

			if(kLeft > 0){
				for(int i = 0; i < n && graph[place][i] > 0; i++){
					if(graph[place][i] > 0){
						q.offer(new int[]{price + graph[place][i], i, kLeft - 1 });
					}
				}
			}
		}

		return -1;
	}
    static public int findCheapestPrice_dp(int n, int[][] flights, int src, int dst, int k) {
        int INF = 0x3F3F3F3F;
        int[] cost = new int[n];
        Arrays.fill(cost, INF);
        cost[src] = 0;
        int ans = INF;
        for(int i = k; i >= 0; i--){
            int[] cur = new int[n];
            Arrays.fill(cur, INF);
            for(int[] flight : flights){ // flight = [src, dest, cost]
                cur[flight[1]] = Math.min(cur[flight[1]], cost[flight[0]] + flight[2]);
            }
            cost = cur;
            ans = Math.min(ans, cost[dst]);
        }
        return ans == INF ? -1 : ans;
    }
	public static void main(String[] args) {
		int n = 4, flights[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}}, src = 0, dst = 3, k = 1;
		//int res =  findCheapestPrice(n, flights, src, dst, k);
		int res =  findCheapestPrice_dp(n, flights, src, dst, k);
		System.out.println(res);
	}
}
