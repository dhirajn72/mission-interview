class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(cloned==null)
            return target;
        if(original==null)
            return target;
        return getTarget(cloned,target);
    }
    TreeNode getTarget(TreeNode cloned,TreeNode target){
        if(cloned==null)
            return null;
        if(cloned==target)
            return cloned;
        TreeNode left = getTarget(cloned.left,target);
        if(left!=null)
            return left;
        return getTarget(cloned.right,target);
    }
}
