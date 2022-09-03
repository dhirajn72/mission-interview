public class NumberOfOperationsToMakeNetworkConnected {
    static public int makeConnected(int n, int[][] connections) {
        if(n == 0 || connections == null || connections.length == 0)
            return 0;

        int cable = 0;
        UnionFind uf = new UnionFind(n);
        for(int[] edge : connections){
            if(uf.union(edge[0], edge[1])){
                cable++;
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++)
            if(uf.id[i] == i)
                max++;
        return (cable >= max - 1) ? max - 1 : -1;
        //return uf.getComponent() + cable  >= n - 1 ? cable : -1;
    }

    static class UnionFind{
        int max;
        int[] size, id;
        int component;
        UnionFind(int max){
            this.max = max;
            this.size = new int[max];
            this.id = new int[max];
            for(int i = 0; i < max; i++){
                this.id[i] = i;
                this.size[i] = 1;
            }
        }
        int getComponent(){
            return this.component;
        }


        int find(int p){
            int root = p;
            while(root != id[root])
                root = id[root];
            while(p != root){
                int next = id[p];
                id[p] = root;
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
                id[root1] = root2;
                size[root1] = 0;
            }
            else{
                size[root1] += size[root2];
                id[root2] = root1;
                size[root2] = 0;
            }
            component++;
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        int n = 6;
        System.out.println(makeConnected(n, connections));
    }
}