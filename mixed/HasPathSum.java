class Solution {
    int sum=0;
    boolean result=false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return result;
        int[] arr=new int[getSize(root)];
        this.sum=sum;
        min(root,arr,0);
        return result;
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
        int sum=0;
        for(int j=0;j<i;j++){
            sum+=arr[j];
        }
        if(sum==this.sum)
            result=true;
    }
}

}
