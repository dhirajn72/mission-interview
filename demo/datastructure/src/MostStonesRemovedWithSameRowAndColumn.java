public class MostStonesRemovedWithSameRowAndColumn {
		public int removeStones(int[][] stones) {
			UnionFind uf = new UnionFind(stones.length);
			for(int[] row : stones){
				uf.union(row[0],row[1]);
			}
			return uf.numComponent;

		}
		class UnionFind{
			int[] id,size;
			int max, numComponent;
			UnionFind(int max){
				this.max = numComponent = max;
				this.id = new int[max];
				this.size = new int[max];
				for(int i = 0 ; i < max; i++){
					id[i] =  i;
					size[i] = 1;
				}
			}

			int find(int p){
				int root = p;
				while( root != id[root])
					root = id[root ];

				while( p != root){
					int next = id[p];
					id[p] = root;
					p = next;
				}
				return root ;
			}

			void union(int p, int q){
				int root1 = find(p);
				int root2 = find(q);
				if(root1 == root2 )
					return ;

				if(size[root1] < size[root2]){
					size[root2]  += size[root1];
					id[root1] = root2;
					size[root1] = 0;
				}
				else{
					size[root1] += size[root2];
					id[root2] = root1;
					size[root2] = 0;
				}
				numComponent--;
			}
		}
	public static void main(String[] args){
		MostStonesRemovedWithSameRowAndColumn ob = new MostStonesRemovedWithSameRowAndColumn();
		int[][] stones= {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
		System.out.println(ob.removeStones(stones));
	}
}
