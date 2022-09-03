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
        return increasingTree(root);
    }
    TreeNode increasingTree(TreeNode root){
        if(root==null)
            return null;
        List<Integer> inOrder=inOrder(root);
        root=null;
        TreeNode temp=null;
        for(int i:inOrder){
            if(root==null){
                root=new TreeNode(i);
                temp=root;
            }
            else{
                TreeNode node=new TreeNode(i);
                temp.right=node;
                temp=temp.right;
            }
        }
        return root;
    }
    List<Integer> inOrder(TreeNode root){
        List<Integer> result=new ArrayList<>();
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
