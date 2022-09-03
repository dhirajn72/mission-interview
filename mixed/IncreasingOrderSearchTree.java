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
    public TreeNode increasingBST(TreeNode root) {
        if(root==null)
            return null;
        List<Integer> inOrder=inOrder(root);
        TreeNode result=null;
        TreeNode temp=null;
        for(int val:inOrder){
            if(result==null){
                result=new TreeNode(val);
                temp=result;
            }
            else{
                temp.right=new TreeNode(val);
                temp=temp.right;
            }
        }
        return result;
    }
    List<Integer> inOrder(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        Stack<TreeNode> s=new Stack<>();
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
        return result;
    }
}
