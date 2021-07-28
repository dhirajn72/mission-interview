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
            return root;
        List<Integer> inOrder=inOrder(root);
        TreeNode result=null,temp=null;
        for(int i:inOrder){
            if(result==null){
                result=new TreeNode(i);
                temp=result;
            }
            else{
                temp.right=new TreeNode(i);
                temp=temp.right;
            }
        }
        return result;
    }

    List<Integer> inOrder(TreeNode root){
        if(root==null)
            return new ArrayList<>();
        List<Integer> result=new ArrayList();
        Stack<TreeNode> stack=new Stack();
        while(!stack.isEmpty() ||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=stack.pop();
                result.add(temp.val);
                root=temp.right;
            }
        }
        return result;
    }
}
