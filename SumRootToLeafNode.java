class Solution {
    int result=0;
    public int sumRootToLeaf(TreeNode root) {
        if(root==null)
            return 0;
        int[] arr=new int[getTreeSize(root)];
        findSum(root,arr,0);
        return result;
    }

    int getTreeSize(TreeNode root){
        if(root==null)
            return 0;
        int size=1;
        size+=getTreeSize(root.left);
        size+=getTreeSize(root.right);
        return size;
    }
    
    void findSum(TreeNode root,int[] arr,int i){
        if(root==null)
            return ;
        arr[i++]=root.val;
        if(root.left==null && root.right==null)
            print(arr,i);
        else{
            findSum(root.left,arr,i);
            findSum(root.right,arr,i);
        }
    }
    void print(int[] arr,int i){
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<i;j++)
            sb.append(arr[j]);
        result+=Integer.valueOf(sb.toString(),2);
    }
}
