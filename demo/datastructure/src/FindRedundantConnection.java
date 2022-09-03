import java.util.Arrays;

public class FindRedundantConnection {
		public int[] findRedundantConnection(int[][] edges) {
			UnionFind uf = new UnionFind(edges.length);
			for(int[] edge : edges){
				if(uf.union(edge[0]-1, edge[1]-1))
					return new int[]{edge[0],edge[1]};
			}

			return new int[]{};
		}
	public static void main(String[] args) {
		//int[][] isConnected = {{1,2},{1,3},{2,3}};
		int[][] isConnected = {{9,10},{5,8},{2,6},{1,5},{3,8},{4,9},{8,10},{4,10},{6,8},{7,9}};
		FindRedundantConnection rd = new FindRedundantConnection();
		int[] res = rd.findRedundantConnection(isConnected);
		System.out.println(Arrays.toString(res));

	}
	class UnionFind{
		int[] id;
		int[] size;
		int max;

		UnionFind(int max){
			this.max = max;
			this.id = new int[max];
			this.size = new int[max];
			for( int i = 0 ; i < max ; i++){
				id[i] = i;
				size[i] = 1;
			}
		}
		boolean isConnected(int p,int q){
			return find(p) == find(q);
		}
		int find(int p){
			int root = p;
			while( root != id[root])
				root =  id[root];

			while(p != root){
				int next = id[p] ;
				id[p] = root;
				p = next;
			}
			return root;
		}
		boolean union(int p, int q) {
			int root1 = find(p);
			int root2 = find(q);
			if (root1 == root2)
				return true;
			if (size[root1] < size[root2]) {
				size[root2] += size[root1];
				id[root1] = root2;
				size[root1] = 0;
			} else {
				size[root1] += size[root2];
				id[root2] = root1;
				size[root2] = 0;
			}
			return false;
		}
	}
}
