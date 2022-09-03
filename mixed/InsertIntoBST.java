/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
            return new TreeNode(val);
        return tree(root,val);
    }

    TreeNode tree(TreeNode root,int val){
        if(root==null)
            return new TreeNode(val);
        if(val>root.val){
            root.right=tree(root.right,val);
        }
        else if(val<root.val){
            root.left=tree(root.left,val);
        }
        return root;
    }
}
