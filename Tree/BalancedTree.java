
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
    int min=0;
    int max=0;
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        if(root.left==null && root.right==null)
            return true;
        
        
        minLevel(root);
        maxLevel(root);
        return max-1-min==1 ? true : false;
    }
    void maxLevel(TreeNode root){
        if(root==null)
            return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                max++;
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
    }

    void minLevel(TreeNode root){
        if(root==null)
            return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                if(temp.left==null || temp.right==null)
                    break;
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                min++;
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
    }
}


/*
[1,null,2,null,3]
[1,2,2,3,3,null,null,4,4]
[3,9,20,null,null,15,7]
[1,null,2,null,3]
[]
[1]
[1,2]
[1,null,2,null,3]
[1,2,3,4,5,6,null,8]
false
false
true
false
false
false
true
false

false
false
true
false
true
true
true
false

*/

/
