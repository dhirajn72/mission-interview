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
    public int minDiffInBST(TreeNode root) {
        if(root==null)
            return 0;
        List<Integer> list=inOrder(root);
        int result=Integer.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            result=Math.min(result,list.get(i)-list.get(i-1));
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
