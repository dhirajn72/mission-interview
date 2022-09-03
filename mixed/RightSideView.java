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
   public List<Integer> rightSideView(TreeNode root) {
       if(root==null)
           return result;
        levelOrder(root);
        return result;
   }
   void levelOrder(TreeNode root){
       if(root==null)
           return;
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
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
                int val=list.get(list.size()-1);
                result.add(val);
                list.clear();
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
   }
}
