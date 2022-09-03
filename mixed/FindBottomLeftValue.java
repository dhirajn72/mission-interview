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
    public int findBottomLeftValue(TreeNode root) {
        if(root==null)
            return 0;
        List<Integer> res=levelOrder(root);
        return res.get(0);
    }
    List<Integer> levelOrder(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null)
            return new ArrayList<>();

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
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
                result.add(new ArrayList<>(list));
                if(!q.isEmpty())
                    q.offer(null);
                list.clear();

            }
        }
        return result.get(result.size()-1);
    }
}




