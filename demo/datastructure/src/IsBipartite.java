class IsBipartite {
    static public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        
        for(int i = 0; i < n ; i++){
            if(color[i] == 0 && !dfs(graph,color,1,i)){
                return false;
            }
        }
        return true;
    }

    static boolean dfs(int[][] graph, int[] colors, int color, int node){
        if(colors[node] != 0)
            return colors[node] == color;

        colors[node] = color;
        for(int  next : graph[node]){
            if(!dfs(graph, colors, -color, next )){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        //int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
        int[][] graph = {{1,2},{0,2},{0,1}};
        //int[][] graph = {{1,2},{},{}};
        boolean result = isBipartite(graph);
        System.out.println(result);
    }
}
