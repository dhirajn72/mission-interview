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
            return 0;
        longestPath(root.left,0,true);
        longestPath(root.right,0,false);
        return result;
    }
    void longestPath(TreeNode root,int sum, boolean isLeft){
        if(root==null){
            result=Math.max(result,sum);
            return;
        }
        if(isLeft){
            longestPath(root.right,sum+1,false);
            longestPath(root.left,0,true);
        }
        else{
            longestPath(root.left,sum+1,true);
            longestPath(root.right,0,false);
        }
    }
}
