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
    public int getMinimumDifference(TreeNode root) {
        if(root==null)
            return 0;
        int result=Integer.MAX_VALUE;
        List<Integer> inOrder=inorderTraversal(root);
        for(int i=1;i<inOrder.size();i++){
            result=Math.min(result,inOrder.get(i)-inOrder.get(i-1));
        }
        return result;
    }
    
   public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty() || root!=null){
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
