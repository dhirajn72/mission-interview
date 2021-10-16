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
    List<Integer> inorder=new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        inorder(root);
        for(int i=1;i<inorder.size();i++){
            if(inorder.get(i)<=inorder.get(i-1))
                return false;
        }
        return true;
    }
    void inorder(TreeNode root){
        if(root==null)
            return ;
        Stack<TreeNode> s=new Stack<>();
        while(!s.isEmpty()||root!=null){
            if(root!=null){
                s.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=s.pop();
                inorder.add(temp.val);
                root=temp.right;
            }
        }
    }
}
