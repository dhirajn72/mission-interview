class Solution {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null)
            return null;
        getSum(root);
        return root;
    }
    void getSum(TreeNode root){
        if(root==null)
            return;
        getSum(root.right);
        root.val+=sum;
        sum=root.val;
        getSum(root.left);

    }
}
