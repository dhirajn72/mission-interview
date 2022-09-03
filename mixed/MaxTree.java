public class MaxTree {
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null)
            return null;
        return maxTree(nums,0,nums.length-1);
    }
    
    static public TreeNode maxTree(int[] arr,int low,int high){
        if(low>high)
            return null;
        int i=low,j=high;
        int max=0,index=0;
        while(i<j){
            if(max<arr[i]){
                max=arr[i];//3,6
                index=i; //0,3
            }
            i++; //0,1,2,3
        }
        System.out.println(max);
        TreeNode root=new TreeNode(arr[index]);
        root.left=maxTree(arr,low,index-1);
        root.right=maxTree(arr,index+1,high);
        return root;
    }
    public static void main(String[] args) {
        int[] arr={3,2,1,6,0,5};
        constructMaximumBinaryTree(arr);
    }
    static class TreeNode{
        int val;
        TreeNode left,right;
        TreeNode(int val){
            this.val=val;
        }
    }
}