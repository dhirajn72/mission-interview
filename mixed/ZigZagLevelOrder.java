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
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return result;
        levelOrder(root);
        return result;
        
    }
    void levelOrder(TreeNode root){
        if(root==null)
            return ;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        boolean isLeftToRight=true;
        List<Integer> list=new ArrayList<>();
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
                if(isLeftToRight){
                    result.add(new ArrayList<>(list));
                    isLeftToRight=false;
                }
                else{
                    List<Integer> reverse=new ArrayList<>();
                    for(int i=list.size()-1;i>=0;i--){
                        reverse.add(list.get(i));
                    }
                    result.add(reverse);
                    isLeftToRight=true;
                }
                if(!q.isEmpty())
                    q.offer(null);
                list.clear();
            }
        }
    }
}
