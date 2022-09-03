
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
    int max=0;
    public int maxDepth(TreeNode root) {
        if(root==null)
            return 0;
        levelOrder(root);
        return max;
    }
    void levelOrder(TreeNode root){
        if(root==null)
            return ;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                max++;
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
    }
}


