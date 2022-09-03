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
    int result=1;
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        levelOrder(root);
        return result;
    }
    public void levelOrder(TreeNode root) {
    	if(root==null)
    		return ;
        Queue<TreeNode> q=new LinkedList<>();
    	q.offer(root);
        q.offer(null);
       	while(!q.isEmpty()){
             TreeNode temp=q.poll();   
             if(temp!=null){
                if(temp.left==null && temp.right==null)
                    break;
                if(temp.left!=null)
                   q.offer(temp.left);
                if(temp.right!=null)
                   q.offer(temp.right);
             }
             else{
                result++;
    			if(!q.isEmpty());
    				q.offer(null);
             }
    	}
    }
}
