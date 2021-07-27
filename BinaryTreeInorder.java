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
    List<Integer> result=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) 
            return result;
       // inOrderRecursively(root);
        inOrderIteratively(root);
        return result;
    }
    public void inOrderIteratively(TreeNode root){
        Stack<TreeNode> s=new Stack();
        while(!s.isEmpty() || root!=null){
            if(root!=null){
                s.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=s.pop();
                result.add(temp.val);
                root=temp.right;
            }
        }
    }
    public void inOrderRecursively(TreeNode root){
        if(root!=null){
            inOrderRecursively(root.left);
            inOrderRecursively(root.right);
            result.add(root.val);
        }
    }
}
