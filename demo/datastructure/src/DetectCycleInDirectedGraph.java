import java.util.Arrays;
import java.util.LinkedList;

public class DetectCycleInDirectedGraph {
	int V;
	LinkedList<Integer>[] adjList;

	DetectCycleInDirectedGraph(int ver) {
		V = ver;
		adjList = new LinkedList[V];
		for (int i = 0; i < V; i++)
			adjList[i] = new LinkedList<>();
	}

	enum Color {
		WHITE, GREY, BLACK;
	}

	static void addEdge(DetectCycleInDirectedGraph g, int u, int v) {
		g.adjList[u].add(v);
	}
	static boolean DFSUtil(DetectCycleInDirectedGraph g, int u, Color[] color) {
		color[u] = Color.GREY;
		for (Integer in : g.adjList[u]) {
			if (color[in] == Color.GREY)
				return true;
			if (color[in] == Color.WHITE)
				if(DFSUtil(g, in, color) == true)
					return true;
		}
		color[u] = Color.BLACK;
		return false;
	}

	static boolean isCyclic(DetectCycleInDirectedGraph g) {
		Color[] color = new Color[g.V];
		Arrays.fill(color, Color.WHITE);

		for (int i = 0; i < g.V; i++) {
			if (color[i] == Color.WHITE) {
				if (DFSUtil(g, i, color))
					return true;
			}
		}
		return false;
	}
	public static void main(String[] args){
		//int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
		int[][] graph ={{0, 3}, // AD
		{0, 4}, // AE
		{1, 4}, // BE
		{2, 5}, // CF
		{3, 6}, // DG
		{4, 6}, // EG
		{5, 7}, // FH
		{6, 7}}; // GH
		//theGraph.addEdge(7, 4); // HE Cycle
		DetectCycleInDirectedGraph ob = new DetectCycleInDirectedGraph(graph.length);
		ob.addEdge(ob,0, 3); // AD
		ob.addEdge(ob,0, 4); // AE
		ob.addEdge(ob,1, 4); // BE
		ob.addEdge(ob,2, 5); // CF
		ob.addEdge(ob,3, 6); // DG
		ob.addEdge(ob,4, 6); // EG
		ob.addEdge(ob,5, 7); // FH
		ob.addEdge(ob,6, 7); // GH
		ob.addEdge(ob,7, 4); // HE Cycle

		System.out.println(ob.isCyclic(ob));

	}
}
