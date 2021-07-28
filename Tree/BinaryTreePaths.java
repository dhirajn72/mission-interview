class Solution {
    List<String> result=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)
            return result;
        int[] arr=new int[getSize(root)];
        paths(root,arr,0);
        return result;
    }
    int getSize(TreeNode root){
        if(root==null)
            return 0;
        int size=1;
        size+=getSize(root.left);
        size+=getSize(root.right);
        return size;
    }
    void paths(TreeNode root,int[] arr,int i){
        if(root==null)
            return ;
        arr[i++]=root.val;
        if(root.left==null && root.right==null)
            print(arr,i);
        else{
            paths(root.left,arr,i);
            paths(root.right,arr,i);
        }
    }
    void print(int[] arr,int i){
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<i;j++){
            sb.append(arr[j]+"->");
        }
        sb.delete(sb.length()-2,sb.length());
        result.add(sb.toString());
    }
}
