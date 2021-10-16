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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root);
        return max;
    }
    int dfs(TreeNode root){
        if(root==null)
            return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        int curr=Math.max(root.val,Math.max(root.val+left,root.val+right));
        max=Math.max(max,Math.max(curr,left+root.val+right));
        return curr;
    }
}
