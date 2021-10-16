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
    List<TreeNode> result=new ArrayList<>();
    public boolean isCompleteTree(TreeNode root) {
        if(root==null)
            return true;
        levelOrder(root);
        int i=result.size()-1;
        while(result.get(i)==null){
            i--;
        }
        for(int j=i;j>=0;j--){
            if(result.get(i)==null)
                return false;
        }
        return true;
    }

    public void  levelOrder(TreeNode root) {
        if(root==null)
            return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                result.add(temp);
                q.offer(temp.left);
                q.offer(temp.right);
            }
            else{
                result.add(null);
            }
        }
    }
}
