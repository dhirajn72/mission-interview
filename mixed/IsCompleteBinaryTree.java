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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null)
            return true;
        Stack<String> s=new Stack<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int index=0;
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                s.push(temp.val+"");
                q.offer(temp.left);
                q.offer(temp.right);
            }
            else{
                s.push("#");
            }
        }
        while(!s.isEmpty() && s.peek()=="#"){
            s.pop();
        }

        int count=0;
        while(!s.isEmpty()){
            if(s.pop().equals("#"))
                count++;
        }
        return count >=2 ? false : true;
        
    }
    int getSize(TreeNode root){
        if(root==null)
            return 0;
        int size=1;
        size+=getSize(root.left);
        size+=getSize(root.right);
        return size;
    }
}
