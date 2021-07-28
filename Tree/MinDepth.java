class Solution {
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        return levelOrder(root);
        
    }
    int  levelOrder(TreeNode root){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int count=0;
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                if(temp.left==null && temp.right==null)
                    break;
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                count++;
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
        return count;
    }
}
