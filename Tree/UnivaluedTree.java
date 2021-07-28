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
    Set<Integer> set=new HashSet<>();
    public boolean isUnivalTree(TreeNode root) {
        if(root==null)
            return true;
        set.add(root.val);
        isUnivalTree(root.left);
        isUnivalTree(root.right);
        return !(set.size()>1);
    }
}
