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
    /*Set<Integer> set=new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
            return false;
        if(set.contains(k-root.val))
            return true;
        set.add(root.val);
        return findTarget(root.left,k)||findTarget(root.right,k);
    }
    */
    
    // This backtracking solutions throws TLE on leetcode because it takes longer time to get to the answer
    boolean result=false;
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
            return false;
        int[] arr=new int[getSize(root)];
        fillArr(root,arr);
        findTarget(arr,new ArrayList<>(),0,k);
        return result;
    }
    void findTarget(int[] arr,List<Integer> list,int start,int target){
        if(start==arr.length)
            return ;
        int sum=0;
        for(int val:list){
            sum+=val;
        }
        if(sum>target)
            return ;
        if(sum==target && list.size()==2)
            result= true;
        for(int i=start;i<arr.length;i++){
            list.add(arr[i]);
            findTarget(arr,list,start+1,target);
            list.remove(list.size()-1);
        }
    }

    void fillArr(TreeNode root,int[] arr){
        if(root==null)
            return;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int i=0;
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                arr[i++]=temp.val;
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
        }
    }

    int getSize(TreeNode root){
        if(root==null)
            return 0;
        int size=1;
        size+=getSize(root.left);
        size+=getSize(root.right);
        return size;
    }
}
