
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
    public int getMinimumDifference(TreeNode root) {
       if(root==null)
           return 0;
        int min=Integer.MAX_VALUE;
        List<Integer> list=inOrder(root);
        for(int i=0;i<list.size()-1;i++){
            min=Math.min(min,list.get(i+1)-list.get(i));
        }
        return min;
    }
    List<Integer> inOrder(TreeNode  root){
        List<Integer> list=new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> s=new Stack<>();
        while(!s.isEmpty()||root!=null){
            if(root!=null){
                s.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=s.pop();
                list.add(temp.val);
                root=temp.right;
            }
        }
        return list;
    }
}

