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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;

        return findTargetSum(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }
    int findTargetSum(TreeNode root,int target){
        if(root==null)
            return 0;
        int res=0;
        if(target==root.val)
            res++;
        res +=  findTargetSum(root.left,target-root.val);
        res +=  findTargetSum(root.right,target-root.val);
        return res;
    }
}
