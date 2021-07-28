class Solution {
    int sum=0;
    public int sumRootToLeaf(TreeNode root) {
        if(root==null)
            return 0;
        int[] arr=new int[getSize(root)];
        findSum(root,0,arr);
        return sum;
    }
    int getSize(TreeNode root){
        if(root==null)
            return 0;
        int sum=1;
        sum+=getSize(root.left);
        sum+=getSize(root.right);
        return sum;
    }
    void findSum(TreeNode root, int i , int[] arr){
        if(root==null)
            return ;
        arr[i++]=root.val;
        if(root.left==null && root.right==null)
            makeSum(arr,i);
        else{
            findSum(root.left,i,arr);
            findSum(root.right,i,arr);
        }
    }
    void makeSum(int[] arr,int i){
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<i;j++){
            sb.append(arr[j]);
        }
        sum+=Integer.parseInt(sb.toString(),2);
    }
}
