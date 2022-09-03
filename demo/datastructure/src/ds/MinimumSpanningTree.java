package ds;

import java.util.Stack;

public class MinimumSpanningTree {
	Vertex[] vertices;
	int[][] matrix;
	int max;
	int count;
	Stack<Integer> stack;
	MinimumSpanningTree(int max) {
		this.max=max;
		vertices=new Vertex[max];
		matrix=new int[max][max];
		stack=new Stack<>();
	}
	void addVertex(char vertex) {
		vertices[count++]=new Vertex(vertex);
	}
	void addEdges(int src,int dest) {
		matrix[src][dest]=1;
		matrix[dest][src]=1;
	}
	void display(int v) {
		System.out.print(vertices[v].c);
	}
	void dfs(int start) {
		vertices[start].isVisited=true;
		//display(start);
		stack.push(start);
		while(!stack.isEmpty()) {
			int currentVertex=stack.peek();
			int v=getUnvisitedNode(currentVertex);
			if(v!=-1 ) {
				vertices[v].isVisited=true;
				display(currentVertex);
				display(v);
				System.out.println(" ");
				stack.push(v);
			}
			else {
				stack.pop();
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
		MinimumSpanningTree bfs=new MinimumSpanningTree(5);
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
		bfs.dfs(0);
	}
}
