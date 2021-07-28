class Solution {
    boolean result=false;
    int sum=0;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        int[] arr=new int[getSize(root)];
        this.sum=sum;
        hasPath(arr,0,root,sum);
        return result;
    }
    void  hasPath(int[] arr,int i,TreeNode root,int sum ){
        if(root==null)
            return ;
        arr[i++]=root.val;
        if(root.left==null && root.right==null)
            path(arr,i);
        else{
            hasPath(arr,i,root.left,sum);
            hasPath(arr,i,root.right,sum);
        }
    }
    void path(int[] arr,int i){
        int val=0;
        for(int j=0;j<i;j++){
            val+=arr[j];
        }
        if(val==sum)
            result=true;
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
