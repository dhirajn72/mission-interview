import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Graph has cycle or not.
 */
public class DetectCycleInGraph {
        enum Color{
            White, Grey, Black;
        }
         public boolean isCyclic(int[][] graph) {

            Color[] color = new Color[graph.length];
            Arrays.fill(color, Color.White);

            for( int i = 0; i < graph.length ; i++){
                if(dfs(graph, i, color)){
                	return true;
                }
            }
            return false;
        }

        boolean dfs(int[][] graph, int start, Color[] color){
            color[start] = Color.Grey;

            for(int child : graph[start]){
                if( color[child] == Color.Grey) 
                    return true;
                if( color[child] == Color.White){
                    if( dfs( graph, child, color)){
                        return true;
                    }
                }
            }
            color[start] = Color.Black;
            return false;
        }
        public static void main(String[] args){
            //int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
            /*
            int[][] graph ={{3, 4}, // AD
                        {4}, // AE
		                {5}, // BE
		                {6}, // CF
		                {6}, // DG
		                {7}, // EG
		                {7}, // FH
                        {}}; //
            */
            int[][] graph ={{3, 4}, // AD
                    {4}, // AE
                    {5}, // BE
                    {6}, // CF
                    {6}, // DG
                    {7}, // EG
                    {7}, // FH
                    {4}}; //
            DetectCycleInGraph ob = new DetectCycleInGraph();
            System.out.println(ob.isCyclic(graph));// cycle
        }
}
