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
    int result=0;
    int curr=0;
    public int sumEvenGrandparent(TreeNode root) {
        if(root==null)
            return result;
        int[] arr=new int[getSize(root)];
        storeInArray(arr,root);
        int index=0;
        for(int i=0;i<curr/2;i++){
            int leftChild=(2*i)+1;
            int rightChild=(2*i)+2;
            if(arr[i]%2 == 0 && (arr[leftChild]!=0 || arr[rightChild]!=0)){
                result+=arr[leftChild]+arr[rightChild];
            }
        }
        return result;
    }
    void storeInArray(int[] arr,TreeNode root){
        List<Integer> list=getList(root);
        int index=0;
        for(int e:list){
            arr[index++]=e;
        }
    }

    List<Integer> getList(TreeNode root){
        if(root==null)
            return new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                result.add(temp.val);
                if(temp.left!=null)
                    q.offer(temp.left);
                else
                    q.offer(null);
                if(temp.right!=null)
                    q.offer(temp.right);
                else
                    q.offer(null);
            }
            else{
                result.add(0);
                if(!q.isEmpty())
                    q.offer(null);
            }
        }
        return result;
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
