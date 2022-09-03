    
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
    public int sumEvenGrandparent(TreeNode root) {
        int sum=0;
        if(root==null)
            return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                q.add(temp.left);
                q.add(temp.right);
                if(temp.val%2==0){
                    if(temp.left!=null){
                        if(temp.left.left!=null)
                            sum+=temp.left.left.val;
                        if(temp.left.right!=null)
                            sum+=temp.left.right.val;
                    }
                    if(temp.right!=null){
                        if(temp.right.left!=null)
                            sum+=temp.right.left.val;
                        if(temp.right.right!=null)
                            sum+=temp.right.right.val;
                    }
                }
            }
        }
        return sum;
    }
}
