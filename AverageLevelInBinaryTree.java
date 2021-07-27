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
    List<Double> result=new ArrayList<Double>();
    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null)
            return null;

        levelOrder(root);
        return result; 
    }
    void levelOrder(TreeNode root){
        if(root==null)
            return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> list=new ArrayList<Integer>();
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
                double sum=0.0;
                for(int d:list){
                    sum+=d;
                }
                result.add(sum/list.size());
                if(!q.isEmpty())
                    q.offer(null);
                list.clear();
            }
        }
    }
}

