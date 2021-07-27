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
    TreeNode prev=null,head=null;
    public TreeNode increasingBST(TreeNode root) {
        if(root==null)
            return null;
        List<TreeNode> inOrder=inOrder(root);
        TreeNode result=null;
        TreeNode temp=null;
        for(TreeNode e:inOrder){
            if(result==null){
                result=e;
                temp=result;
            }
            else{
                temp.right=e;
                temp=temp.right;
            }
        }
        return result;
    }
    List<TreeNode> inOrder(TreeNode root){
        if(root==null)
            return new ArrayList<>();
        Stack<TreeNode> s=new Stack<>();
        List<TreeNode> result=new ArrayList<>();
        while(!s.isEmpty()||root!=null){
            if(root!=null){
                s.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=s.pop();
                result.add(temp);
                temp.left=null;
                root=temp.right;
                temp.right=null;
            }
        }
        return result;
    }
}
