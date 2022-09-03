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
    public TreeNode bstToGst(TreeNode root) {
        if(root==null)
            return root;
        Stack<TreeNode> s=new Stack<>();
        TreeNode result=root;
        int sum=0;
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
