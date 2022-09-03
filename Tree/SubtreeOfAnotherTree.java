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
    boolean result=false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)
            return true;
        if(root==null || subRoot==null)
            return false;
        Stack<TreeNode> s=new Stack<>();
        while(!s.isEmpty() || root!=null){
            if(root!=null){
                s.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=s.pop();
                if(temp.val==subRoot.val){
                    boolean isSame=isSame(temp,subRoot);
                    if(isSame){
                        result=true;
                    }
                }
                root=temp.right;
            }
        }
        return result;
    }
    public boolean isSame(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)
            return true;
        if(root==null || subRoot==null)
            return false;
        if(root.val!=subRoot.val)
            return false;
        return isSame(root.left,subRoot.left) || isSame(root.right,subRoot.right);
    }
}
