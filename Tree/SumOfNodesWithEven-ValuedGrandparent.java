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
    //int result=0;
    public int sumEvenGrandparent(TreeNode root) {
        if(root==null)
            return 0;
        int result=0;
        if(root.val%2==0 && root.left!=null && root.left.left!=null){
            result+=root.left.left.val;
        }
        if(root.val%2==0 && root.left!=null && root.left.right!=null){
            result+=root.left.right.val;
        }
        if(root.val%2==0 && root.right!=null && root.right.left!=null){
            result+=root.right.left.val;
        }
        if(root.val%2==0 && root.right!=null && root.right.right!=null){
            result+=root.right.right.val;
        }
        
        result+=sumEvenGrandparent(root.left);
        result+=sumEvenGrandparent(root.right);
        return result;
    }
}
