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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root==null)
            return root;
        if(depth==1){
            TreeNode parent=new TreeNode(val);
            parent.left=root;
            return parent;
        }
        int count=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<TreeNode> list=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode temp=q.poll();   
            if(temp!=null){
                list.add(temp);
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                count++;
                if(count==depth-1){
                   for(TreeNode node:list){
                       TreeNode left=node.left;
                       TreeNode right=node.right;
                       node.left=new TreeNode(val);
                       node.right=new TreeNode(val);
                       node.left.left=left;
                       node.right.right=right;
                   }
                }
                list.clear();
                if(!q.isEmpty())
                    q.offer(null);

            }
        }
        return root;
    }
}
