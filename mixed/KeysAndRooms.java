class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isVisited=new boolean[rooms.size()];
        Queue<Integer> queue=new LinkedList<>();
        isVisited[0]=true;
        queue.offer(0);
        while(!queue.isEmpty()){
            int v=queue.remove();
            List<Integer> keys=rooms.get(v);
            for(int key:keys){
                if(isVisited[key]==false){
                    isVisited[key]=true;
                    queue.offer(key);
                }
            }
        }
        for(int i=0;i<rooms.size();i++)
            if(!isVisited[i])
                return false;
        return true;

    }
}
