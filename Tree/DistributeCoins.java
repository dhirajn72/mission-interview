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
    public int distributeCoins(TreeNode root) {
        if(root==null)
            return 0;
        distributeCoin(root);
        return result;
    }
    int distributeCoin(TreeNode root){
        if(root==null)
            return 0;
        int left=distributeCoin(root.left);
        int right=distributeCoin(root.right);
        result=Math.abs(left)+Math.abs(right);
        return left+root.val+right-1;
    }
}
