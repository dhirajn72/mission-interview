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
    public TreeNode balanceBST(TreeNode root) {
        if(root==null)
            return null;
        int[] arr=new int[getSize(root)];
        fillArr(arr,root);
        return buildTree(arr,0,arr.length-1);
    }
    TreeNode buildTree(int[] arr,int low,int high){
        if(low>high)
            return null;
        int mid=(low+high)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=buildTree(arr,low,mid-1);
        root.right=buildTree(arr,mid+1,high);
        return root;
    }
    void fillArr(int[] arr,TreeNode root){
        Stack<TreeNode> s=new Stack<>();
        int index=0;
        while(!s.isEmpty() || root!=null){
            if(root!=null){
                s.push(root);
                root=root.left;
            }
            else{
                TreeNode temp=s.pop();
                arr[index++]=temp.val;
                root=temp.right;
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
