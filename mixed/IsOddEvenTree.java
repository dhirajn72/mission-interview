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
    public boolean isEvenOddTree(TreeNode root) {
        if(root==null)
            return true;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        boolean isEven=true;
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                list.add(temp.val);
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                if(isEven){
                    for(int i=1;i<list.size();i++){
                        if(list.get(i) <= list.get(i-1))
                            return false;
                    }
                    for(int e:list){
                        if(e%2 == 0){
                            return false;
                        }
                    }
                    isEven=false;
                }
                else{
                    for(int i=1;i<list.size();i++){
                        if(list.get(i) >= list.get(i-1))
                            return false;
                    }
                    for(int e:list){
                        if(e%2 != 0){
                            return false;
                        }
                    } 
                    isEven=true;
                }
                list.clear();
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
        return true;
    }
}
