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
        longestZigZag(root.left,0,true);
        longestZigZag(root.right,0,false);
        return result;
    }
    void longestZigZag(TreeNode root,int count,boolean isLeft){
        if(root==null){
            result=Math.max(result,count);
        }
        else{
            if(isLeft){
                longestZigZag(root.right,count+1,false);
                longestZigZag(root.left,0,true);
            }
            else{
                longestZigZag(root.left,count+1,true);
                longestZigZag(root.right,0,false);
            }
        }
    }
}
