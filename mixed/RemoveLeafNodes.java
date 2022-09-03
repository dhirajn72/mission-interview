class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null)
            return null;
        root.left= removeLeafNodes(root.left,target);
        root.right= removeLeafNodese(root.right,target);
        if(root.val==target)
            return null;
        return root;
    }

}
