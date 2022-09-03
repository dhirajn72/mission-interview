import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] vertices = new boolean [rooms.size()]; 
        Queue<Integer> queue = new LinkedList<>();
        vertices[0] = true;
        queue.offer(0);
        while(!queue.isEmpty()){
            int v = queue.remove();
            List<Integer> list = rooms.get(v);
            for(int key : list){
                if(!vertices[key]){
                    vertices[key] = true;
                    queue.offer(key);
                }
            }
        }
        
        for(int i = 0; i < vertices.length; i++){
            if(!vertices[i])
                return false;
        }
        return true;
    }
  }
