class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int leftDiameter=diameterOfBinaryTree(root.left);
        int rightDiameter=diameterOfBinaryTree(root.right);
        int height= height(root.left)+height(root.right);
        return Math.max(height,Math.max(leftDiameter,rightDiameter));
    }

    int height(TreeNode root){
        if(root==null)
            return 0;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        return 1 + Math.max(leftHeight,rightHeight);
    }
}
