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
    boolean result=false;
    Set<Integer> set=new HashSet<>();
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        dfs(root,targetSum);
        return result;
    }
    void dfs(TreeNode root,int target){
        if(root==null)
            return;
        if(root.val==target && root.left==null && root.right==null){
            result=true;
        }
        if(root.left!=null){
            dfs(root.left,target-root.val);
        }
        if(root.right!=null){
            dfs(root.right,target-root.val);
        }
    }
}
