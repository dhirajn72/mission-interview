import java.util.ArrayList;
import java.util.Stack;

public class FindIfPathExistsInGraph {
    class UnionFind{
        int max;
        int[] id;
        int[] size;
        int numComponents;
        
        UnionFind(int max){
            this.max = max;
            this.numComponents = max;
            this.size = new int[max];
            this.id = new int[max];
            for(int  i = 0; i < max ;i++){
                id[i] = i;
                size[i] = 1;
            }
        }
        int find(int p){
            int root =  p;
            while(root != id[root]){
                root = id[root];
            }

            // This is path compression
            while( p != root){
                int next = id[p];
                id[p] = root;
                p = next;
            }
            return root;
        }
        void union(int p , int q) {
            int root1 = find(p);
            int root2 = find(q);
            if (root1 == root2)
                return;

            if (size[root1] < size[root2]) {
                size[root2] += size[root1];
                id[root1] = root2;
                size[root1] = 0;
            } else {
                size[root1] += size[root2];
                id[root2] = root1;
                size[root2] = 0;
            }
            numComponents--;

        }

        boolean isConnected(int p, int q){
            return find(p) == find(q);
        }

    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFind unionFind = new UnionFind(n);
        for(int[] edge : edges){
            unionFind.union(edge[0],edge[1]);
        }
        return unionFind.isConnected(source,destination);
    }
    public static void main(String[] args){
        int n = 6, edges[][] = {{0,1},{0,2},{3,5},{5,4},{4,3}}, source = 0, destination = 5;
        FindIfPathExistsInGraph graph = new FindIfPathExistsInGraph();
        System.out.println(graph.validPath(n,edges,source,destination));
    }
}
