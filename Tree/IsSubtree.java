class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==t)
            return true;
        if(s==null &&  t==null)
            return true;
        if(s==null || t==null)
            return false;
        if(s.val==t.val){
           boolean result=  isSubTree(s,t);
           if(result)
                return result;
        }
        return isSubtree(s.left,t) || isSubtree(s.right,t);
        
    }
    boolean isSubTree(TreeNode s,TreeNode t){
        if(s==null && t==null)
            return true;
        if(s==null || t==null)
            return false;
        if(s.val!=t.val)
            return false;
        return  isSubtree(s.left,t.left) && isSubtree(s.right,t.right);
        
    }
}
