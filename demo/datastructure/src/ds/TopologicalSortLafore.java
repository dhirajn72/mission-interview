package ds;

import java.util.Stack;

public class TopologicalSortLafore {
	int[][] matrix;
	int max;
	Vertex[] vertices;
	Stack<Character> sorted;

	TopologicalSortLafore(int max){
		this.vertices = new Vertex[max];
		this.sorted = new Stack<>();
		this.matrix = new int[max][max];
	}
	void addEdge(int source, int dest){
		matrix[source][dest] = 1;
	}
	void addVertex(char c){
		vertices[max++] = new Vertex(c);
	}

	boolean topo(){
		while( max > 0){
			int v = nosuccessors();
			if(v == -1)
				return true; // Graph has cycle and topological sort cannot be performed !!!
			sorted.push(vertices[v].c);
			deleteVertex(v);
		}
		return false;
	}
	void deleteVertex(int v){
		if( v != max-1){
			for(int i = v; i < max - 1; i++){
				vertices[i] = vertices[i+1];
			}
			for(int i = v; i < max - 1; i++){
				for(int j = 0; j < max; j++){
					matrix[i][j] = matrix[i+1][j];
				}
			}
			for(int j = v ; j < max - 1 ; j++){
				for(int i = 0; i < max - 1 ; i++){
					matrix[i][j] =  matrix[i][j+1];
				}
			}
		}
		max--;
	}
	int nosuccessors(){
		boolean isEdge;
		for(int i = 0 ;i < max ; i++ ){
			isEdge = false;
			for(int j = 0; j < max; j++){
				if(matrix[i][j] > 0){
					isEdge = true;
					break;
				}
			}
			if(!isEdge)
				return i;
		}
		return -1;
	}
	public static void main(String[] args) {
		TopologicalSortLafore theGraph = new TopologicalSortLafore(8);
		theGraph.addVertex('A'); // 0
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addVertex('F'); // 5
		theGraph.addVertex('G'); // 6
		theGraph.addVertex('H'); // 7
		theGraph.addEdge(0, 3); // AD
		theGraph.addEdge(0, 4); // AE
		theGraph.addEdge(1, 4); // BE
		theGraph.addEdge(2, 5); // CF
		theGraph.addEdge(3, 6); // DG
		theGraph.addEdge(4, 6); // EG
		theGraph.addEdge(5, 7); // FH
		theGraph.addEdge(6, 7); // GH
		//theGraph.addEdge(7, 4); // Cycle
		System.out.print("Topologically sorted order: ");
		if(!theGraph.topo()) {
			while (!theGraph.sorted.isEmpty())
				System.out.print(theGraph.sorted.pop() + "->");
			System.out.println("");
		}
		else
			System.out.println("Graph has cycle !!");
	}
}