package ds;

import java.util.Arrays;

public class DijkstraAlgorithm {
		int vertices;
		int matrix[][];
		public DijkstraAlgorithm(int vertex) {
			this.vertices = vertex;
			matrix = new int[vertex][vertex];
		}
		public void addEdge(int source, int destination, int weight) {
			matrix[source][destination] = weight;
			matrix[destination][source] = weight;
		}
		int getMinimumVertex(boolean[] visited, int[] distance) {
			int minKey = Integer.MAX_VALUE;
			int vertex = -1;
			for (int i = 0; i < vertices; i++) {
				if ( !visited[i] &&  distance[i] < minKey) {
					minKey = distance[i];
					vertex = i;
				}
			}
			return vertex;
		}
		public void dijkstra(int sourceVertex) {
			boolean[] visited = new boolean[vertices];
			int[] distance = new int[vertices];
			Arrays.fill(distance,Integer.MAX_VALUE);

			distance[sourceVertex] = 0;
			for (int i = 0; i < vertices; i++) {
				int v = getMinimumVertex(visited, distance);
				visited[v] = true;
				for (int j = 0; j < vertices; j++) {
					if (matrix[v][j] > 0) {
						if ( !visited[j] && matrix[v][j] != Integer.MAX_VALUE ) {
							int newKey = matrix[v][j] + distance[v];
							if (newKey < distance[j])
								distance[j] = newKey;
						}
					}
				}
			}
			printDijkstra(sourceVertex, distance);
		}

		public void printDijkstra(int sourceVertex, int[] key) {
			System.out.println("Dijkstra Algorithm: (Adjacency Matrix)");
			for (int i = 0; i < vertices; i++) {
				System.out.println("Source ds.Vertex: " + sourceVertex + " to vertex " + +i + " distance: " + key[i]);
			}
	}

	public static void main(String[] args) {
		int vertices = 7;
		DijkstraAlgorithm graph = new DijkstraAlgorithm(vertices);
		int sourceVertex = 0;
		//[[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
		graph.addEdge(0, 6, 7);
		graph.addEdge(0, 1, 2);
		graph.addEdge(1, 2, 3);
		graph.addEdge(1, 3, 3);
		graph.addEdge(6, 3, 3);
		graph.addEdge(3, 5, 1);
		graph.addEdge(6, 5, 1);
		graph.addEdge(2, 5, 1);
		graph.addEdge(0, 4, 5);
		graph.addEdge(4, 6, 2);
		graph.dijkstra(sourceVertex);
	}
}
