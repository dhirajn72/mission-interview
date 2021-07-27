/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> result=new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null)
            return result;

        findKDistance(target,k);
        return result;
    }
    void findKDistance(TreeNode root,int k){
        if(root==null)
            return;
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        int count=0;
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            if(temp!=null){
                count++;
                if(temp.left!=null)
                    s.offer(temp.left);
                if(temp.right!=null)
                    s.offer(temp.right);
                if(count==k){
                    if(temp.left!=null)
                        result.add(temp.left.val);
                    if(temp.right!=null)
                        result.add(temp.right.val);
                }

            }
        }
    }
}
