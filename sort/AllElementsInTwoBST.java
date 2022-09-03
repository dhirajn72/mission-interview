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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1=inOrder(root1);
        List<Integer> list2=inOrder(root2);
        return merge(list1,list2);
    }
    List<Integer> merge(List<Integer> list1,List<Integer> list2){
        List<Integer> result=new ArrayList<>();
        List<Integer> p=list1;
        List<Integer> q=list2;
        int i=0,j=0;
        while(i<p.size() && j<q.size()){
            if(p.get(i)<q.get(j)){
                result.add(p.get(i));
                i++;
            }
            else{
                result.add(q.get(j));
                j++;
            }
        }
        while(i<p.size()){
            result.add(p.get(i++));
        }
        while(j<q.size()){
            result.add(q.get(j++));
        }
        return result;
    }
    List<Integer> inOrder(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack=new Stack<>();
        while(!stack.isEmpty() || root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=stack.pop();
                result.add(temp.val);
                root=temp.right;
            }
        }
        return result;
    }
}
