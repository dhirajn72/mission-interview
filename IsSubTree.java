class Solution {
    boolean result=false;
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null||t==null)
            return true;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(s);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                if(temp.val==t.val){
                    boolean res=findSubtree(temp,t);
                    if(res)
                        return true;
                }
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
        }
        return false;
    }
    boolean findSubtree(TreeNode s,TreeNode t){
        if(s==null && t==null){
            return true;
        }
        if(s==null || t==null){
            return false;
        }
        return s.val==t.val && findSubtree(s.left,t.left) && findSubtree(s.right,t.right);
    }
}
