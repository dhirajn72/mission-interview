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
    List<Integer> result=new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        //List<Integer> list1=getList(root1);
        //List<Integer> list2=getList(root2);
        //return merge(list1,list2);
        anotherWay(root1);
        anotherWay(root2);
        Collections.sort(result);
        return result;
    }
    void anotherWay(TreeNode root){
        if(root==null)
            return;
        result.add(root.val);
        anotherWay(root.left);
        anotherWay(root.right);
    }

    List<Integer> merge(List<Integer> list1,List<Integer> list2){
        List<Integer> result=new ArrayList<>();
        int i=0;
        int j=0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i)<list2.get(j)){
                result.add(list1.get(i));
                i++;
            }
            else{
                result.add(list2.get(j));
                j++;
            }
        }
        while(i<list1.size()){
            result.add(list1.get(i));
            i++;
        }
        while(j<list2.size()){
            result.add(list2.get(j));
            j++;
        }
        return result;
    }
    List<Integer> getList(TreeNode root){
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
        return result;
    }
}
