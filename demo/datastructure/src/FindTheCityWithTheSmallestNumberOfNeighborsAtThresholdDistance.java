import java.util.Arrays;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtThresholdDistance {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];
        for(int row = 0 ; row < n; row++){
            Arrays.fill(graph[row],Integer.MAX_VALUE);
            graph[row][row] =  0;
        }
        for(int[] edge : edges ){
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }

        for( int k = 0; k < n ; k++){
            for( int i = 0 ; i < n ; i++){
                for( int j = 0; j < n ; j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j] );
                }
            }
        }

        int minReachable = n, res = 0;
        for(int i = 0 ; i < n ; i++){
            int reachable = 0;
            for( int j = 0 ; j < n ; j++){
                if( graph[i][j] <= distanceThreshold){
                    reachable++;
                }
                if( reachable <= minReachable){
                    minReachable = reachable;
                    res = i;
                }
            }
        }
        return res;
    }
}
