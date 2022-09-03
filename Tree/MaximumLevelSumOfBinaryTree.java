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
    public int maxLevelSum(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int sum=Integer.MIN_VALUE;
        int result=0;
        int level=1;
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                list.add(temp.val);
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
            else{
                int max=0;
                for(int val:list){
                    max+=val;
                }
                if(max>sum){
                    result=level;
                    sum=max;
                }
                list.clear();
                if(!q.isEmpty())
                    q.offer(null);
                level++;
            }
        }
        return result;
    }
}
