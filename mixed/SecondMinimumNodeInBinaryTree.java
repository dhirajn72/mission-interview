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
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null)
            return -1;
        preOrder(root);
        Collections.sort(list);
        if(list.size()<=1)
            return -1;
        return list.get(1);
    }
    void preOrder(TreeNode root){
        if(root==null)
            return ;
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            if(temp!=null){
                if(!list.contains(temp.val)){
                    list.add(temp.val);
                   // Collections.sort(list);
                }
                if(temp.left!=null)
                    s.push(temp.left);
                if(temp.right!=null)
                    s.push(temp.right);
            }
        }
    }
}
