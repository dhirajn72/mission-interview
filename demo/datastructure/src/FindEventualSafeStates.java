import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Graph has cycle or not.
 */
public class FindEventualSafeStates{
        enum Color{
            White, Grey, Black;
        }
         public List<Integer> eventualSafeNodes(int[][] graph) {
            List<Integer> res = new ArrayList<>();

            Color[] color = new Color[graph.length];
            Arrays.fill(color, Color.White);
            for( int i = 0; i < graph.length ; i++){
                if(!dfsHasCycle(graph, i, color)){
                    res.add(i);
                }
            }
            return res;
        }

        boolean dfsHasCycle(int[][] graph, int start, Color[] color){
            color[start] = Color.Grey;

            for(int child : graph[start]){
                if( color[child] == Color.Grey) 
                    return true;
                if( color[child] == Color.White){
                    if( dfsHasCycle( graph, child, color)){
                        return true;
                    }
                }
            }
            color[start] = Color.Black;
            return false;
        }
        public static void main(String[] args){
            int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
            //int[][] graph ={{0, 3}, // AD
            //            {0, 4}, // AE
		    //            {1, 4}, // BE
		    //            {2, 5}, // CF
		    //            {3, 6}, // DG
		    //            {4, 6}, // EG
		    //            {5, 7}, // FH
		    //            {6, 7}}; // GH
		                //(7, 4); // HE Cycle
            FindEventualSafeStates ob = new FindEventualSafeStates();
            System.out.println(ob.eventualSafeNodes(graph));
        }
}
