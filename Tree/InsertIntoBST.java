class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        return insert(root,val);
    }
    TreeNode insert(TreeNode root,int val){
        if(root==null)
            return new TreeNode(val);
        if(val>root.val){
            root.right=insert(root.right,val);
        }
        if(val<root.val){
            root.left=insert(root.left,val);
        }
        return root;
    }
}
