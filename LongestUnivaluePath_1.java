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
    int result=0;
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
            return 0;
        longestPath(root);
        return result;
    }
    int longestPath(TreeNode root){
        if(root==null)
            return 0;
        int left=longestPath(root.left);
        int right=longestPath(root.right);
        int l=0;
        int r=0;
        if(root.left!=null && root.left.val==root.val)
            l=left+1;
        if(root.right!=null && root.right.val==root.val)
            r=right+1;
        result=Math.max(result,l+r);
        return Math.max(l,r);
    }
}
