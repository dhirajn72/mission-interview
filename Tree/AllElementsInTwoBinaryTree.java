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
        System.out.println(list1);
        System.out.println(list2);
       
        return merge(list1,list2);

    }
    List<Integer> merge(List<Integer> l1,List<Integer> l2){
        List<Integer> result=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<l1.size() && j<l2.size()){
            if(l1.get(i)<l2.get(j)){
                result.add(l1.get(i));
                i++;
            }
            else{
                result.add(l2.get(j));
                j++;
            }
        }
        if(i<l1.size()){
            for(int k=i;k<l1.size();k++)
                result.add(l1.get(k));
        }
        if(j<l2.size()){
            for(int k=j;k<l2.size();k++)
                result.add(l2.get(k));
        }
        return result;
    }

    List<Integer> inOrder(TreeNode root){
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        Stack<TreeNode> s=new Stack<>();
        while(!s.isEmpty() || root!=null){
            if(root!=null){
                s.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=s.pop();
                result.add(temp.val);
                root=temp.right;
            }
        }
        return new ArrayList(result);
    }
}
