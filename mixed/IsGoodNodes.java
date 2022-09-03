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
    int result=1;
    public int goodNodes(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left!=null){
            if(root.left.val>root.val)
                result++;
        }
        if(root.right!=null){
            if(root.right.val>root.val)
                result++;
        }
        goodNodes(root.left);
        goodNodes(root.right);
        return result;
    }
}
