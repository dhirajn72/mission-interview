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
    TreeNode result=null;
    public TreeNode bstToGst(TreeNode root) {
        if(root==null)
            return root;
        result=root;
        Stack<TreeNode> s=new Stack<TreeNode>();
        while(!s.isEmpty()||root!=null){
            if(root!=null){
                s.push(root);
                root=root.right;
            }
            else{
                TreeNode temp=s.pop();
                temp.val+=sum;
                sum=temp.val;
                root=temp.left;
            }
        }
        return result;
    }
}
