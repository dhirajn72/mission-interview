class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int left=diameterOfBinaryTree(root.left);
        int right=diameterOfBinaryTree(root.right);
        int height=height(root.left)+height(root.right);
        return Math.max(height,Math.max(left,right));
    }

    int height(TreeNode root){
        if(root==null)
            return 0;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
}
