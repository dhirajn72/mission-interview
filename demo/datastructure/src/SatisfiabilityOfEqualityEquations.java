class SatisfiabilityOfEqualityEquations{
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind();
        for( String s : equations){
            if(s.charAt(1) == '=')
                uf.union(s.charAt(0) - 'a', s.charAt(3) - 'a');
        }
        for( String s : equations){
            if(s.charAt(1) == '!'){
                if(uf.find(s.charAt(0) - 'a') == uf.find(s.charAt(3) - 'a'))
                    return false;
            }
        }
        return true;

    }
    class UnionFind{
        int[] chars = new int[26];
        int[] size = new int[26];
        UnionFind(){
            for( int i = 0 ; i < size.length ; i++){
                chars[i] = i;
                size[i] = 1;
            }
        }

        int find( int p ){
            int root = p;
            while( root != chars[root]){
                root = chars[root];
            }
            while( p != root){
                int next = chars[p];
                chars[p] = root;
                p = next;
            }
            return root;
        }
        void union(int p ,int q){
            int root1 = find(p);
            int root2 = find(q);
            if( root1 == root2)
                return;
            if( size[root1] < size[root2]){
                size[root2] += size[root1];
                chars[root1] = root2;
                size[root1] = 0;
            }
            else{
                size[root1] += size[root2];
                chars[root2] = root1;
                size[root2] = 0;
            }
        }
    }
}
