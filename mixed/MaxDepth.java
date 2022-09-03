class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int result=0;
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                result++;
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
        return result;
    }
}
