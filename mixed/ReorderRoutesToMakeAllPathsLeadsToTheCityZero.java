class Solution {
    public int minReorder(int n, int[][] connections) {
        Set<Integer> set=new HashSet<>();
        for(int[] node:connections){
            set.add(node[0]);
            set.add(node[1]);
        }
        boolean[] isVisited=new boolean[n];
        int[][] matrix=new int[n][n];
        for(int[] edge:connections){
            matrix[edge[0]][edge[1]]=1;
            matrix[edge[0]][edge[0]]=1;
        }
        for(int i=0;i<n;i++){
            bfs(i,matrix,isVisited);
        }

        //Second part is to collect all the nodes which are ingress to 0th node;
       /* List<Integer> ingressList=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(matrix[i][0]==1 && !isVisited[i])
                ingressList.add(i);
        }
        for(int i=0;i<ingressList.size();i++){
            bfs(ingressList.get(i),matrix,isVisited);
        }*/
        
        System.out.println(Arrays.deepToString(matrix));

        int result=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==Integer.MAX_VALUE)
                    result++;
            }
        }
        return result;

    }
    void bfs(int src,int[][] matrix,boolean[] isVisited){
        Queue<Integer> q=new LinkedList<>();
        isVisited[src]=true;
        q.offer(src);
        int v;
        while(!q.isEmpty()){
            int v1=q.remove();
            while( (v=getUnvisitedNode(v1,matrix,isVisited))!=-1 ){
                isVisited[v]=true;
                q.offer(v);
            }
        }
    }
    int getUnvisitedNode(int v,int[][] matrix,boolean[] isVisited){
        for(int i=0;i<matrix.length;i++){
            if(matrix[v][i]==1 && !isVisited[i]){
                if(matrix[i][v]!=1){
                    matrix[i][v]=Integer.MAX_VALUE;
                }
                return i;
            }
        }
        return -1;
    }
}
