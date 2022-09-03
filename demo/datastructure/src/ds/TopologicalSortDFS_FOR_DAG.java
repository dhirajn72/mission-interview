package ds;

import java.util.Stack;

public class TopologicalSortDFS_FOR_DAG {
	Vertex[] vertices;
	int[][] matrix;
	int max;
	int count;
	Stack<Integer> stack;
	static Stack<Character> topo;
	TopologicalSortDFS_FOR_DAG(int max) {
		this.max=max;
		vertices=new Vertex[max];
		matrix=new int[max][max];
		stack=new Stack<>();
		topo = new Stack<>();
	}
	void addVertex(char vertex) {
		vertices[count++]=new Vertex(vertex);
	}
	void addEdge(int src,int dest) {
		matrix[src][dest]=1;
		//matrix[dest][src]=1;
	}
	void display(int v) {
		System.out.print(vertices[v].c+"->");
	}
	void dfs() {
		for (int i = 0; i < vertices.length; i++) {
			if(vertices[i].isVisited)
				continue;
			vertices[i].isVisited = true;
			//display(start);
			stack.push(i);
			while (!stack.isEmpty()) {
				int v = getUnvisitedNode(stack.peek());
				if (v != -1) {
					vertices[v].isVisited = true;
					//display(v);
					stack.push(v);
				} else {
					topo.push(vertices[stack.pop()].c);
				}
			}
		}
	}
	int getUnvisitedNode(int v) {
		for (int i = 0; i < vertices.length; i++) {
			if(matrix[v][i]==1 && !vertices[i].isVisited)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		/*TopologicalSortDFS bfs=new TopologicalSortDFS(5);
		bfs.addVertex('A');
		bfs.addVertex('B');
		bfs.addVertex('C');
		bfs.addVertex('D');
		bfs.addVertex('E');
		bfs.addEdges(0,1);
		bfs.addEdges(0,4);
		bfs.addEdges(1,2);
		bfs.addEdges(1,3);
		bfs.addEdges(4,3);
		bfs.dfs(0);*/
		TopologicalSortDFS_FOR_DAG theGraph=new TopologicalSortDFS_FOR_DAG(8);
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
		theGraph.dfs();
		System.out.println();
		while (!topo.isEmpty()){
			System.out.print(topo.pop()+"->");
		}
	}
}
