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
    List<Integer> result=new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        levelOrder(root);
        return result;
    }
    void levelOrder(TreeNode root){
        if(root==null)
            return ;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> level=new LinkedList<>();
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                level.add(temp.val);
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                int max=Integer.MIN_VALUE;
                for(int val:level){
                    max=Math.max(max,val);
                }
                result.add(max);
                if(!q.isEmpty()){
                    q.offer(null);
                }
                level.clear();
            }
        }
    }
}
