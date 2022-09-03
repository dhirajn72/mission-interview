import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCenterOfGraph {
    class Solution {
        public int findCenter(int[][] edges) {
            Map<Integer,List<Integer>> map = new HashMap<>();

            for(int[] edge : edges){
                if(map.containsKey(edge[0])){
                    map.get(edge[0]).add(edge[1]);
                    if(map.containsKey(edge[1])){
                        map.get(edge[1]).add(edge[0]);
                    }
                    else{
                        map.put(edge[1],new ArrayList<>());
                        map.get(edge[1]).add(edge[0]);
                    }
                }
                else{
                    map.put(edge[0],new ArrayList<>());
                    map.get(edge[0]).add(edge[1]);
                    if(map.containsKey(edge[1])){
                        map.get(edge[1]).add(edge[0]);
                    }
                    else{
                        map.put(edge[1],new ArrayList<>());
                        map.get(edge[1]).add(edge[0]);
                    }
                }
            }
            int valueMax = 0;
            int result = 0;
            for(int key : map.keySet()){
                if(map.get(key).size() > valueMax){
                    valueMax = map.get(key).size();
                    result = key;
                }
            }
            return result;
        }
    }
}
