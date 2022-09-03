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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Queue<Integer> q1=inOrder(root1);
        Queue<Integer> q2=inOrder(root2);
        mergeList(q1,q2);
        return list;
    }
    void mergeList(Queue l1,Queue l2){
        while(!l1.isEmpty() && !l2.isEmpty()){
            int v1=(int)l1.peek();
            int v2=(int)l2.peek();
           
            if(v1 < v2){
                list.add((int)l1.poll());
            }
            else{
                list.add((int)l2.poll());
            }
        }
        
        while(!l1.isEmpty()){
            list.add((int)l1.poll());
        }
        while(!l2.isEmpty()){
          list.add((int)l2.poll());
        }
    }
    Queue<Integer> inOrder(TreeNode root){
        if(root==null)
            return new LinkedList<>();
        Queue<Integer> result=new LinkedList<>();
        Stack<TreeNode> s=new Stack<>();
        while(!s.isEmpty()||root!=null){
            if(root!=null){
                s.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=s.pop();
                result.offer(temp.val);
                root=temp.right;
            }
        }
        return result;
    }
}
