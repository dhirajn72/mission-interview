class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result=new ArrayList<>();
        Queue<List<Integer>> q=new LinkedList<>();
        q.offer(Arrays.asList(0));
        int goalNode=graph.length-1;
        while(!q.isEmpty()){
            List<Integer> paths=q.poll();
            int lastNode=paths.get(paths.size()-1);
            if(lastNode==goalNode){
                result.add(new ArrayList<>(paths));
            }
            else{
                int[] neighbours=graph[lastNode];
                for(int i:neighbours){
                    List<Integer> path=new ArrayList<>(paths);
                    path.add(i);
                    q.offer(path);
                }
            }
        }
        return result;
    }
}
