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
    List<Integer> list=new ArrayList<>();
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null)
            return -1;
        minLevel(root);
        if(list.size()==1)
            return -1;
        Collections.sort(list);
        return list.get(1); 
    }
    int getSize(TreeNode root){
        if(root==null)
            return 0;
        int size=root.val;
        size+=getSize(root.left);
        size+=getSize(root.right);
        return size;

    }
    void minLevel(TreeNode root){
        if(root==null)
            return ;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                if(!list.contains(temp.val)){
                    list.add(temp.val);
                }
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
        }
    }
}
