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
            return null;
        Stack<TreeNode> s=new Stack<>();
        Stack<Integer> res=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            if(temp!=null){
                res.push(temp.val);
                if(temp.left!=null)
                    s.push(temp.left);
                if(temp.right!=null)
                    s.push(temp.right);
            }
        }
        while(!res.isEmpty()){
            result.add(res.pop());
        }
        return result;
    }
}
