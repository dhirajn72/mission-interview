import java.util.PriorityQueue;

public class CoupleHoldingHands {
	static public int minSwapsCouples(int[] row) {
		int N = row.length / 2;
		UnionFind  uf = new UnionFind(N);
		for (int i = 0; i < N; i++) {
			int a = row[2*i];
			int b = row[2*i + 1];
			uf.union(a/2, b/2);
		}
		return N - uf.count;
	}

	static class UnionFind{
		int[] ids, size;
		int count;
		UnionFind(int max){
			this.ids = new int[max];
			this.size = new int[max];
			this.count = max;
			for(int i = 0; i < max; i++){
				this.ids[i] = i;
				this.size[i] = 1;
			}
		}
		int find(int p){
			int root = p;
			while(root != ids[root]){
				root = ids[root];
			}
			while(root != p){
				int next = ids[p];
				ids[p] = root;
				p = next;
			}
			return root;
		}
		boolean union(int p, int q){
			int root1 = find(p);
			int root2 = find(q);
			if(root1 == root2) return true;

			if(size[root1] < size[root2]){
				size[root2] += size[root1];
				ids[root1] = root2;
				size[root1] = 0;
			}
			else{
				size[root1] += size[root2];
				ids[root2] = root1;
				size[root2] = 0;
			}
			count--;
			return false;
		}
	}

	public static void main(String[] args) {
		int[] row = {0, 2, 1, 3};
		System.out.println(minSwapsCouples(row));

	}
}
