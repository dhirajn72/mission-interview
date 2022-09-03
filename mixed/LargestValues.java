class Solution {
    public List<Integer> largestValues(TreeNode root) {
         if(root==null)
              return new ArrayList<>();
         return largest(root);
    }
    List<Integer> largest(TreeNode root){
          List<Integer> result=new ArrayList<>();
          if(root==null)
               return result;

          Queue<TreeNode> q=new LinkedList<>();
          q.offer(root);
          q.offer(null);
          int max=Integer.MIN_VALUE;
          while(!q.isEmpty()){
               TreeNode temp=q.poll();
               if(temp!=null){
                    max=Math.max(max,temp.val);
                    if(temp.left!=null)
                         q.offer(temp.left);
                    if(temp.right!=null)
                         q.offer(temp.right);
               }
               else{
                    result.add(max);
                    if(!q.isEmpty())
                         q.offer(null);
                    list.clear();
               }
          }
          return result;
     }
}
