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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)
            return false;
        boolean isOnSameLevel=isSameLevel(root,x,y);
        if(!isOnSameLevel){
            return false;
        }
        TreeNode root1=getRoot(root,x);
        TreeNode root2=getRoot(root,y);
        if(root1!=null && root2!=null && root1!=root2)
            return true;
        return false;
    }
    TreeNode getRoot(TreeNode root,int x){
        if(root==null)
            return null;
        if(root.left!=null && root.left.val==x)
            return root;
        if(root.right!=null && root.right.val==x)
            return root;
        TreeNode left=getRoot(root.left,x);
        if(left!=null)
            return left;
        return getRoot(root.right,x);

    }

    boolean isSameLevel(TreeNode root,int x,int y){
        if(root==null)
            return false;
        Set<Integer> set=new HashSet<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                set.add(temp.val);
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                if(!q.isEmpty())
                    q.offer(null);
                if(set.contains(x) && set.contains(y))
                    return true;
                set.clear();
            }
        }
        return false;
    }
}
