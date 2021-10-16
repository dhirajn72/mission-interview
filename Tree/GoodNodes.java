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

 //TODO: This solution is incomplete.
class Solution {
    int result=0;
    int max=Integer.MIN_VALUE;
    public int goodNodes(TreeNode root) {
        preorder(root);
        return result;
    }
    void preorder (TreeNode root){
        if(root==null)
            return ;
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            if(temp!=null){
                if(temp.val>=max){
                    result++;
                    max=temp.val;
                }
                if(temp.right!=null)
                    s.push(temp.right);
                if(temp.left!=null)
                    s.push(temp.left);
            }
        }
    }
}
