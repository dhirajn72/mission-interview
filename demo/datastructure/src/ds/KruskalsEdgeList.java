package ds;

import java.util.Arrays;

/**
 * An implementation of Kruskal's MST algorithm using an edge list Time Complexity: O(ElogE)
 */
public class KruskalsEdgeList {
	static class UnionFind {
		private int[] id, size;
		public UnionFind(int n) {
			id = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				id[i] = i;
				size[i] = 1;
			}
		}

		public int find(int p) {
			int root = p;
			while (root != id[root])
				root = id[root];

			while (p != root) { // Do path compression
				int next = id[p];
				id[p] = root;
				p = next;
			}
			return root;
		}

		public boolean connected(int p, int q) {
			return find(p) == find(q);
		}

		public int size(int p) {
			return size[find(p)];
		}

		public void union(int p, int q) {
			int root1 = find(p);
			int root2 = find(q);
			if (root1 == root2) return;

			if (size[root1] < size[root2]) {
				size[root2] += size[root1];
				id[root1] = root2;
			} else {
				size[root1] += size[root2];
				id[root2] = root1;
			}
		}
	}

	static class Edge implements Comparable<Edge> {
		int from, to, cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge other) {
			return cost - other.cost;
		}
	}

	// Given a graph represented as an edge list this method finds
	// the Minimum Spanning Tree (MST) cost if there exists
	// a MST, otherwise it returns null.
	static Long kruskals(Edge[] edges, int n) {
		if (edges == null)
			return null;

		long sum = 0L;
		Arrays.sort(edges);
		UnionFind uf = new UnionFind(n);
		for (Edge edge : edges) {
			// Skip this edge to avoid creating a cycle in MST
			if (uf.connected(edge.from, edge.to))
				continue;

			// Include this edge
			uf.union(edge.from, edge.to);
			sum += edge.cost;
			System.out.println(edge.from + " : " + edge.to + " -> "+edge.cost);

			// Optimization to stop early if we found
			// a MST that includes all the nodes
			if (uf.size(0) == n)
				break;
		}

		// Make sure we have a MST that includes all the nodes
		if (uf.size(0) != n) return null;
		return sum;
	}
	public static void main(String[] args) {
		KruskalsEdgeList kruskals = new KruskalsEdgeList();

		// Draw these vertex and edges on paper for more clarity.
		int[][] graph = new int[][] {
				{0,1,2,7,0},
				{1,0,6,9,5},
				{2,6,0,3,0},
				{7,9,3,0,4},
				{0,5,0,3,0}
		};
		Edge[] edges =  new Edge[16]; // There are 16 edges in above matrix
		edges[0] = new Edge(0,1,1);
		edges[1] = new Edge(0,2,2);
		edges[2] = new Edge(0,3,7);
		edges[3] = new Edge(1,0,1);
		edges[4] = new Edge(1,2,6);
		edges[5] = new Edge(1,3,9);
		edges[6] = new Edge(1,4,5);
		edges[7] = new Edge(2,0,2);
		edges[8] = new Edge(2,1,6);
		edges[9] = new Edge(2,3,3 );
		edges[10] = new Edge(3,0,7);
		edges[11] = new Edge(3,1,9);
		edges[12] = new Edge(3,2,3);
		edges[13] = new Edge(3,4,3);
		edges[14] = new Edge(4,1,5);
		edges[15] = new Edge(4,3,3);
		long minCost = kruskals.kruskals(edges,5);
		System.out.println("Minimum cost of MST is : "+ minCost);
	}
}
