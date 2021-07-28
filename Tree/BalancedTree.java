class Solution {
    int min=0;
    int max=0;
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        minLevel(root);
        levelOrder(root);
        int result=max-min;
        return result>=0?(result==1?true:false):false;
    }

    void minLevel(TreeNode root){
        if(root==null)
            return ;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                if(temp.left==null && temp.right==null){
                    min++;
                    break;
                }
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
        }
    }
    void levelOrder(TreeNode root){
        if(root==null)
            return ;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                max++;
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
        }
    }
}
