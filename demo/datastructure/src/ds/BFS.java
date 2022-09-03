package ds;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	Vertex[] vertices;
	int[][] matrix;
	int max;
	int count;
	Queue<Integer> queue;
	BFS(int max) {
		this.max=max;
		vertices=new Vertex[max];
		matrix=new int[max][max];
		queue=new LinkedList<>();
	}
	void addVertex(char vertex) {
		vertices[count++]=new Vertex(vertex);
	}
	void addEdges(int src,int dest) {
		matrix[src][dest]=1;
		matrix[dest][src]=1;
	}
	void display(int v) {
		System.out.print(vertices[v].c+"->");
	}
	void bfs(int start) {
		vertices[start].isVisited=true;
		display(start);
		queue.offer(start);
		int v2;
		while(!queue.isEmpty()) {
			int v=queue.remove();
			while ( (v2=getUnvisitedNode(v))!=-1 ) {
				vertices[v2].isVisited=true;
				display(v2);
				queue.offer(v2);
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
		BFS bfs=new BFS(5);
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
		bfs.bfs(0);
	}
}
