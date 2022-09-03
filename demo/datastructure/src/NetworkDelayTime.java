import java.util.Arrays;

class NetwordDelayTime {
    public int networkDelayTime(int[][] times, int n, int K) {
        int[] graph = new int[n];
        Arrays.fill(graph,Integer.MAX_VALUE);
        graph[K - 1] = 0;
        for( int i = 0; i < n ; i++ ){
            for( int[] rows : times){
                graph[rows[1]-1] = Math.min(graph[rows[1] - 1], graph[rows[0]-1] + rows[2]) ;
            }
        }

        int result = Integer.MIN_VALUE;
        for( int i : graph){
            result = Math.max(result,i);
        }
        return result;
        
    }
}
