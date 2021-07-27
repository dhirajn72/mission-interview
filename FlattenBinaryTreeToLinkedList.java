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
    public void flatten(TreeNode root) {
        if(root==null)
            return ;
        List<Integer> preOrder=preOrder(root);
        root.left=null;
        root.right=null;
        TreeNode temp=root;
        for(int i=1;i<preOrder.size();i++){
            temp.right=new TreeNode(preOrder.get(i));
            temp=temp.right;
        }
    }
    List<Integer> preOrder(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            if(temp!=null){
                result.add(temp.val);
                if(temp.right!=null)
                    s.push(temp.right);
                if(temp.left!=null)
                    s.push(temp.left);
            }
        }
        return result;
    }
}
