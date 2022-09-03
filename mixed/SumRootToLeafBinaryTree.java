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
    List<Integer> resultList=new ArrayList<>();
    public int sumRootToLeaf(TreeNode root) {
        if(root==null)
            return 0;
        int[] arr=new int[1000];
        getRootToLeaf(root,arr,0);
        int result=0;
        for(int val:resultList){
            result+=val;
        }
        return result;
    }
    void getRootToLeaf(TreeNode root,int[] arr,int i){
        if(root==null)
            return ;
        arr[i++]=root.val;
        if(root.left==null && root.right==null){
            addToList(arr,i);
        }
        else{
            getRootToLeaf(root.left,arr,i);
            getRootToLeaf(root.right,arr,i);
        }
    }
    void addToList(int[] arr,int i){
        StringBuilder sb=new StringBuilder();
        int pow=0;
        int number=0;
        for(int j=i-1;j>=0;j--){
            number+= Math.pow(2,pow++) * arr[j];
        }
        resultList.add(number);
    }
}
