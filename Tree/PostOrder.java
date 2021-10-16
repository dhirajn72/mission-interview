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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        Stack<Integer> stack=new Stack<>();     
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            if(temp!=null){
                stack.push(temp.val);
                if(temp.left!=null){
                    s.push(temp.left);
                }
                if(temp.right!=null){
                    s.push(temp.right);
                }
            }
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        return result;
        
    }
} 
