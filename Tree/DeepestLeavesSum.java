class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if(root==null)
            return 0;
        return lastLevelSum(root);
    }


    int> lastLevelSum(TreeNode root){
       Queue<TreeNode> q=new LinkedList<>();
       q.offer(root);
       q.offer(null);
       List<List<Integer>> result=new ArrayList<>(); 
       List<Integer> list=new ArrayList<>();
       while(!q.isEmpty()){
           TreeNode temp=q.poll();
           if(temp!=null){
               list.add(temp.val);
               if(temp.left!=null)
                   q.offer(temp.left);
               if(temp.right!=null)
                   q.offer(temp.right);
           }
           else{
               result.add(new ArrayList<>(list));
               if(!q.isEmpty())
                   q.offer(null);
               list.clear();
           }
       }
       int sum=0;
       for(int i:result.get(result.size()-1)){
           sum+=i;
       }
       return sum;
   }
}

