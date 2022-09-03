class Solution {
    int val=0;
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        val=root.val;
        return isUnival(root.left) && isUnival(root.right);
    }
    boolean isUnival(TreeNode root){
        if(root==null)
            return true;
        if(root.val!=val)
            return false;
        return isUnival(root.left) && isUnival(root.right);
    }
}
