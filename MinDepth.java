class Solution {
    int res=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int[] arr=new int[getSize(root)];
        min(root,arr,0);
        return res;
    }
    void min(TreeNode root,int[] arr, int i){
        if(root==null)
            return;
        arr[i++]=root.val;
        if(root.left==null && root.right==null)
            print(arr,i);
        else{
            min(root.left,arr,i);
            min(root.right,arr,i);
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
    void print(int[] arr,int i){
        int j=0;
        for( j=0;j<i;j++);
        res=Math.min(res,j);
    }
}
