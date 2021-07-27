
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
    public int sumRootToLeaf(TreeNode root) {
        if(root==null)
            return 0;

        getPaths(root);
        return result;
    }
    int getDecimal(int n){
        int result=0,p=0;
        while(n>0){
            int temp=n%10;
            result+=temp*Math.pow(2,p);
            n=n/10;
            p++;
        }
        return result;
    }
    void  getPaths(TreeNode root){
        if(root==null)
            return;
        int[] arr=new int[1000];
        getPaths(root,arr,0);
    }
    void getPaths(TreeNode root,int[] arr,int i){
        if(root==null)
            return;
        arr[i++]=root.val;
        if(root.left==null && root.right==null){
            print(arr,i);
        }
        else{
            getPaths(root.left,arr,i);
            getPaths(root.right,arr,i);
        }
    }
    void print(int[] arr,int i){
        StringBuilder val=new StringBuilder();
        for(int j=0;j<i;j++){
            val.append(arr[j]);
        }
        System.out.println(val);
        result+=Integer.parseInt(val.toString(),2);
    }
}
