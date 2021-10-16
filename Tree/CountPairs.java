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
//TODO: This solution is not complete, its buggy, fails for few test cases. 
class Solution {
    public int countPairs(TreeNode root, int distance) {
        if(root==null)
            return 0;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right)

        int leftDiameter=countPairs(root.left,distance);
        int rightDiameter=countPairs(root.right,distance);

        return result;
    }
    int height(TreeNode root){
        if(root==null)
            return null;
        int left=height(root.left);
        int right=height(root.right);
        return Math.max(left,right)+1;
    }
}
