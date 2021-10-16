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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        return levelOrder(root);
        
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> list=new ArrayList<>();
        boolean flag=true;
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
                if(flag){
                    result.add(new ArrayList<>(list));
                    flag=false;
                }
                else{
                    List<Integer> reversed=new ArrayList<>();
                    for(int i=list.size()-1;i>=0;i--){
                        reversed.add(list.get(i));
                    }
                    result.add(reversed);
                    flag=true;
                }
                if(!q.isEmpty()){
                    q.offer(null);
                }
                list.clear();
            }
        }
        return result;
    }
}
