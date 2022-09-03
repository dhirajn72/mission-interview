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
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        return isUnivalued(root,root.val);
    }
    boolean isUnivalued(TreeNode root,int val){
        if(root==null){
            return true;
        }
        if(root.val!=val){
            return false;
        }
        return isUnivalued(root.left,root.val) && isUnivalued(root.right,root.val);
        
    }
}
