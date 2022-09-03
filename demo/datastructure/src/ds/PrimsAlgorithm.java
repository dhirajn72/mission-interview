package ds;

import java.util.Arrays;

public class PrimsAlgorithm {
	private static final int V = 5;
	int minKey(int key[], boolean[] mstSet) {
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < V; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}
		return min_index;
	}
	void printMST(int[] parent, int[][] graph) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
	}
	void primMST(int graph[][]) {
		int[] parent = new int[V];
		int[] key = new int[V];
		boolean[] mstSet = new boolean[V];

		Arrays.fill(key,Integer.MAX_VALUE);
		key[0] = 0;
		parent[0] = -1;
		for (int count = 0; count < V ; count++) {
			int u = minKey(key, mstSet);
			mstSet[u] = true;
			for (int v = 0; v < V; v++)
				if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}
		printMST(parent, graph);
	}

	public static void main(String[] args) {
		PrimsAlgorithm primsAlgorithm = new PrimsAlgorithm();

		int[][] graph = new int[][] {
				{0,1,2,7,0},
				{1,0,6,9,5},
				{2,6,0,3,0},
				{7,9,3,0,3},
				{0,5,0,3,0}
		};
		// Print the solution
		primsAlgorithm.primMST(graph);
	}
}
