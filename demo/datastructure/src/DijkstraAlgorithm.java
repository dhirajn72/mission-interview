import java.util.Arrays;

public class DijkstraAlgorithm {
	int[][] graph;
	int n;

    DijkstraAlgorithm(int n){
        this.n = n;
        this.graph = new int[n][n];
    }
    void addEdge(int src,int dest,int weight){
        graph[src][dest] = weight;
        graph[dest][src] = weight;
    }

    void dijkstra(int src){
        int[] distance = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        Arrays.fill(distance,Integer.MAX_VALUE);

        distance[src] = 0;
        for( int i = 0 ; i < graph.length; i++){
            int v = getMinIndex(distance,visited);
            visited[v] = true;
            for(int j =0 ; j < graph.length ; j++){
                if( graph[v][j] > 0){
                    if( !visited[j] && graph[v][j] != Integer.MAX_VALUE){
                        int newDistance = graph[v][j] + distance[v];
                        if( newDistance < distance[j]){
                            distance[j] = newDistance;
                        }
                    }
                }
            }
        }
        printDistance(distance,src);
    }
    void printDistance(int[] distance ,int src){
        for(int i = 0 ; i < distance.length; i++){
            System.out.println("Shortest path from from source :" + src +" to destination :"+ i + " is : "+ distance[i]);
        }
    }

    int getMinIndex(int[] distance, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int vertex = -1 ;
        for(int i = 0; i < distance.length; i++){
            if( !visited[i] && distance[i] < min){
                min = distance[i];
                vertex = i;
            }
        }
        return vertex;
    }

    public static void main(String[] args) {
        int vertices = 6;
        DijkstraAlgorithm obj = new DijkstraAlgorithm(6);
        int sourceVertex = 0;
        obj.addEdge(0, 1, 4);
        obj.addEdge(0, 2, 3);
        obj.addEdge(1, 2, 1);
        obj.addEdge(1, 3, 2);
        obj.addEdge(2, 3, 4);
        obj.addEdge(3, 4, 2);
        obj.addEdge(4, 5, 6);

        obj.dijkstra(sourceVertex);
    }
}
