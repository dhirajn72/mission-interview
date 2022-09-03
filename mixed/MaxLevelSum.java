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
    int maxSum=Integer.MIN_VALUE;
    int maxLevel=Integer.MIN_VALUE;
    public int maxLevelSum(TreeNode root) {
        if(root==null)
            return 0;
        levelOrder(root);
        return maxLevel;
    }
    void levelOrder(TreeNode root){
        if(root==null)
            return ;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> list=new ArrayList<>();
        int maxLevelSum=Integer.MIN_VALUE;
        int level=0;
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                list.add(temp.val);
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                level++;
                int sum=0;
                for(int e:list){
                    sum+=e;
                }
                if(maxLevelSum < sum){
                    maxLevelSum=sum;
                    maxLevel=level;
                }
                if(!q.isEmpty())
                    q.offer(null);
                list.clear();
            }
        }

    }
}
