import java.util.ArrayList;
import java.util.List;

public class MakeAllPathsLeadsToCityZero {
    static public int minReorder(int n, int[][] connections) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < connections.length; i++){
            int[] edge = connections[i];
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(-edge[0]);
        }
        return dfs(list, new boolean[n], 0);
    }
    static int dfs(List<List<Integer>> lists, boolean[] visited, int src){
        if(src == lists.size()) return 0;
        visited[src] = true;
        int count = 0;
        for(int to : lists.get(src)){
            if(!visited[Math.abs(to)]){
                count += dfs(lists, visited, Math.abs(to)) + ( to > 0 ? 1 : 0);
            }
        }
        return count;
    }

	public static void main(String[] args) {
		int[][] edges = {{0,1},{1,3},{2,3},{4,0},{4,5}};
		int n = 6;
		System.out.println(minReorder(n, edges));
	}
}
