import java.util.Stack;
public class NumberOfProviences {
	static int res = 1;
	static public int findCircleNum(int[][] isConnected) {
		boolean[] visited = new boolean[isConnected.length];
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < isConnected.length; i++){
			for(int j = 0; j < isConnected[0].length; j++){
				if(isConnected[i][j] == 1 && !visited[j]){
					dfs(isConnected, i, stack, visited);
				}
			}
		}
		return res;
	}
	static void dfs(int[][] matrix, int i, Stack<Integer> stack, boolean[] visited){
		visited[i] = true;
		stack.push(i);
		while(!stack.isEmpty()){
			int v = getUnvisitedNode(matrix, visited, stack.peek());
			if(v != -1){
				visited[v] = true;
				stack.push(v);
			}
			else
				stack.pop();
		}
		for(int j = 0; j < visited.length; j++){
			if(!visited[j])
				res++;
		}
	}
	static int getUnvisitedNode(int[][] matrix, boolean[] visited, int v){
		for(int i = 0; i < visited.length ; i++){
			if(matrix[v][i] == 1 && !visited[i]){
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
		int res = findCircleNum(matrix);
		System.out.println(res);
	}
}
