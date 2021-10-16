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
            return null;
        if(depth==1){
            TreeNode node=new TreeNode(val);
            node.left=root;
            return node;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        int count=0;
        List<List<TreeNode>> levels=new ArrayList<>();
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
                    for(TreeNode l:list){
                        TreeNode left=l.left;
                        TreeNode right=l.right;
                        l.left=new TreeNode(val);
                        l.right=new TreeNode(val);
                        l.left.left=left;
                        l.right.right=right;
                    }
                    break;
                }
                if(!q.isEmpty())
                    q.offer(null);
                list.clear();
            }
        }
        return root;
    }
}
