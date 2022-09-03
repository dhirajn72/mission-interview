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
    List<Integer> list=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)
            return 0;
        inOrder(root);
        return list.get(k-1);
    }
    void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> s=new Stack<>();
        while(!s.isEmpty() || root!=null){
            if(root!=null){
                s.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=s.pop();
                list.add(temp.val);
                root=temp.right;
            }
        }
    }
}
