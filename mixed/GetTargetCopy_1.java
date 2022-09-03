/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original ==null && cloned==null)
            return null;
        if(original ==null || cloned==null)
            return null;
        return getTarget(cloned,target);
    }
    TreeNode getTarget(TreeNode root,TreeNode target){
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            if(temp!=null){
                if(temp.val==target.val)
                    return temp;
                if(temp.left!=null)
                    s.push(temp.left);
                if(temp.right!=null)
                    s.push(temp.right);
            }
        }
        return null;
    }
}
