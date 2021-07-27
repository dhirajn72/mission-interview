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
    int result=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        int[] max=new int[1];
        max[0]=Integer.MIN_VALUE;
        maxPathSum(root,max);
        return max[0];
    }
    int maxPathSum(TreeNode root,int[] max){
        if(root==null)
            return 0;
        int left=maxPathSum(root.left,max);
        int right=maxPathSum(root.right,max);
        int curr=Math.max(root.val,Math.max(root.val+left,root.val+right));
        max[0]=Math.max(max[0],Math.max(curr,left+root.val+right));
        return curr;

    }
}
