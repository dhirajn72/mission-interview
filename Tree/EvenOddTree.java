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
        if(root.val%2==0)
            return false;
        return levelOrder(root);
    }
    public boolean levelOrder(TreeNode root) {
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
                        if(list.get(i)%2==0 || list.get(i-1)%2==0)
                            return false;
                        if(list.get(i)<=list.get(i-1))
                            return false;
                    }
                    if(list.size()==1){
                        if(list.get(0)%2==0)
                            return false;
                    }
                    isEven=false;
                }
                else{
                    for(int i=1;i<list.size();i++){
                        if(list.get(i)%2!=0 || list.get(i-1)%2!=0)
                            return false;
                        if(list.get(i)>=list.get(i-1))
                            return false;
                    }
                    if(list.size()==1){
                        if(list.get(0)%2!=0)
                            return false;
                    }
                    isEven=true;
                }
                if(!q.isEmpty()){
                    q.offer(null);
                }
                list.clear();
            }
        }
        return true;
    }
}

/*
   [1,10,4,3,null,7,9,12,8,6,null,null,2]
   [5,4,2,3,3,7]
   [5,9,1,3,5,7]
   [1]
   [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
   [2,12,8,5,9,null,null,18,16]
   [1,10,4,3,null,7,9,12,8,6,null,null,2]
   [5,4,2,3,3,7]
   [5,9,1,3,5,7]
   [1]
   [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
   [2,12,8,5,9,null,null,18,16]
   [5,4,2,3,3,7]
   [5,9,1,3,5,7]
   [5,4,2,3,3,7]
   [2,12,8,5,9,null,null,18,16]
 */
