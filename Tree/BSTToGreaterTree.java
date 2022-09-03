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
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null)
            return null;
        return buildTree(root);
    }
    TreeNode buildTree(TreeNode root){
        if(root==null)
            return null;
        TreeNode result=root;
        Stack<TreeNode> s=new Stack<>();
        while(!s.isEmpty() || root!=null){
            if(root!=null){
                s.push(root);
                root=root.right;
            }
            else{
                TreeNode temp=s.pop();
                sum+=temp.val;
                temp.val=sum;
                root=temp.left;
            }
        }
        return result;
    }
}
