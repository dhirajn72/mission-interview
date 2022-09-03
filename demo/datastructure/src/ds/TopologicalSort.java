package ds;

import java.util.Stack;

public class TopologicalSort {
	private final int MAX_VERTS = 8;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Stack<Character> sorted;

	public TopologicalSort() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		sorted = new Stack<>();
	}

	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].c);
	}

	public boolean topo() {
		while (nVerts > 0) {
			int currentVertex = noSuccessors();
			if (currentVertex == -1) { // -1 found means there must be a cycle, print error
				return true;
			}
			sorted.push(vertexList[currentVertex].c);
			deleteVertex(currentVertex);
		}
		return false;
	}

	public int noSuccessors() {
		boolean isEdge;
		for (int row = 0; row < nVerts; row++) {
			isEdge = false;
			for (int col = 0; col < nVerts; col++) {
				if (adjMat[row][col] > 0) {
					isEdge = true;
					break;
				}
			}
			if (!isEdge)
				return row;
		}
		return -1;
	}


	public void deleteVertex(int delVert) {
		if (delVert != nVerts - 1) {
			for (int j = delVert; j < nVerts - 1; j++)
				vertexList[j] = vertexList[j + 1];

			for (int row = delVert; row < nVerts - 1; row++) {
				for (int col = 0; col < nVerts; col++)
					adjMat[row][col] = adjMat[row + 1][col];
			}

			for (int col = delVert; col < nVerts - 1; col++) {
				for (int row = 0; row < nVerts - 1; row++)
					adjMat[row][col] = adjMat[row][col + 1];
			}
		}
		nVerts--;
	}

	public static void main(String[] args) {
		TopologicalSort theGraph = new TopologicalSort();
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
		//theGraph.addEdge(4, 1); // Cycle
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
