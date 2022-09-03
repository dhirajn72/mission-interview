import java.util.Stack;

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
public class BalanceBST  {
    public TreeNode balanceBST(TreeNode root) {
        if(root==null){
            return null;
        }
        int[] nums=inOrder(root);
        return buildTree(nums,0,nums.length-1);
    }
    TreeNode buildTree(int[] nums,int low,int high){
        if(low>high)
            return null;
        int mid=(low+high)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=buildTree(nums,low,mid-1);
        root.right=buildTree(nums,mid+1,high);
        return root;
    }
    int[] inOrder(TreeNode root){
        int size=getSize(root);
        int[] arr=new int[size];
        int index=0;
        Stack<TreeNode> s=new Stack<>();
        while( !s.isEmpty() || root!=null ){
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
        return arr;
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
