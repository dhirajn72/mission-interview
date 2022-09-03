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
    Map<TreeNode,TreeNode> map=new HashMap<>();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root==null)
            return root;
        if(root.left==null && root.right==null)
            return root;

        List<TreeNode> levelsList=levelOrder(root);
        int index=levelsList.size()-1;
        while(levelsList.get(index)==null){
            index--;
        }
        TreeNode result=levelsList.get((index-1)/2);
        return result.left==null ? result.right:result;
        
    }
    List<TreeNode> levelOrder(TreeNode root){
        if(root==null)
            return null;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        List<TreeNode> list=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                list.add(temp);
                q.offer(temp.left);
                q.offer(temp.right);
            }
            else{
                list.add(null);
            }
        }
        System.out.println(list);
        return list;
    }
}
