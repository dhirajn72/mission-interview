import java.util.Stack;

public  class NumberOfProvience{
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length, result = 0;
            boolean[] isVisited = new boolean[n];
            for( int i = 0; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(isConnected[i][j] ==  1 && !isVisited[i]){
                        dfs(isConnected, isVisited, i);
                        result++;
                    }
                }
            }
            return result;
        }
        void dfs(int[][] isConnected, boolean[] isVisited, int src){
            Stack<Integer> stack = new Stack<>();
            isVisited[src] = true;
            stack.push(src);
            while(!stack.isEmpty()){
                int v = getUnvisitedNode(isConnected, isVisited,stack.peek());
                if( v != -1){
                    isVisited[v]= true;
                    stack.push(v);
                }
                else{
                    stack.pop();
                }
            }
        }
        int getUnvisitedNode(int[][] isConnected, boolean[] isVisited,int v){
            for(int i = 0 ; i < isConnected.length; i++ ){
                if(isConnected[v][i] == 1 && !isVisited[i])
                    return i;
            }
            return -1;
        }
    }
}