public class IsBipartite_1 {
	static public boolean possibleBipartition(int n, int[][] dislikes) {
		int[][] graph = new int[n][n];
		for(int[] edge : dislikes){
			graph[edge[0] - 1][edge[1] - 1] = 1;
			graph[edge[1] - 1][edge[0] - 1] = 1;
		}

		int[] colors = new int[n];
		for(int i = 0; i < n ; i++){
			if(colors[i] == 0 && !dfs(graph,colors,1,i)){
				return false;
			}
		}
		return true;
	}

	static boolean dfs(int[][] graph, int[] colors, int color, int u){
		colors[u] = color;
		for(int v = 0; v < graph.length; v++){
			if(graph[u][v] == 1){
				if (colors[v] == color) {
					return false;
				}
				if( colors[v] == 0 && !dfs(graph, colors, -color, v)){
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] graph = {{1,2},{1,3},{2,4}};
		System.out.println(possibleBipartition(n , graph));

	}
}
