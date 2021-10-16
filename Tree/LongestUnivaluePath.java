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
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root,root.val);
        return max;
    }
    int dfs(TreeNode root,int prevMax){
        if(root==null)
            return 0;
        int left=dfs(root.left,root.val);
        int right=dfs(root.right,root.val);
        max=Math.max(max,left+right);
        if(root.val==prevMax)
            return Math.max(left,right)+1;
        return 0;
    }
}
