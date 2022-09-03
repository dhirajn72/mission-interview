class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        boolean[] isVisited=new boolean[isConnected.length];
        int n=isConnected.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && !isVisited[i]  ){
                    bfs(isConnected,i,isVisited);
                    count++;
                }
            }
        }
        return count;
    }
    void bfs(int[][] isConnected, int i,boolean[] isVisited){
        Queue<Integer> q=new LinkedList<>();
        isVisited[i]=true;
        q.offer(i);
        int v;
        while(!q.isEmpty()){
            int v1=q.remove();
            while( (v=getUnvisitedNode(v1,isConnected,isVisited))!=-1){
                isVisited[v]=true;
                q.offer(v);
            }
        }
    }
    int getUnvisitedNode(int v,int[][] isConnected,boolean[] isVisited){
        for(int i=0;i<isVisited.length;i++){
            if(isConnected[v][i]==1 && !isVisited[i]){
                return i;
            }
        }
        return -1;
    }
}
