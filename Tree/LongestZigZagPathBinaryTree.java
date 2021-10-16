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
    public int longestZigZag(TreeNode root) {
        if(root==null)
            return result;
        findPath(root.left,0,true);
        findPath(root.right,0,false);
        return result;
    }
    void findPath(TreeNode root,int sum,boolean isLeft){
        if(root==null){
            result=Math.max(result,sum);
            return;
        }
        if(isLeft){
            findPath(root.right,sum+1,false);
            findPath(root.left,0,true);
        }
        else{
            findPath(root.left,sum+1,true);
            findPath(root.right,0,false);

        }
    }
}
