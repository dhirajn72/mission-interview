class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       List<List<Integer>> result=new ArrayList<>();

       Queue<List<Integer>> q=new LinkedList<>();
       q.offer(Arrays.asList(0));

       int goalNode=graph.length-1;
       while(!q.isEmpty()){
           List<Integer> path=q.poll();
           int lastNode = path.get(path.size()-1);

           if(lastNode==goalNode){
               result.add(new ArrayList<>(path));
           }
           else{
               int[] neighbours=graph[lastNode];
               for(int neighbour:neighbours){
                   List<Integer> list=new ArrayList<>(path);
                   list.add(neighbour);
                   q.offer(list);
               }
           }
       }
       return result;
   }
}
