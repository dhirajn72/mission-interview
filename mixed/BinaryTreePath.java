class Solution {
    List<String> result=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        int[] arr=new int[getTreeSize(root)];
        paths(root,arr,0);
        return result;
    }
    void paths(TreeNode root,int[] arr,int i){
        if(root==null)
            return;
        arr[i++]=root.val;
        if(root.left==null && root.right==null)
            paths(arr,i);
        else{
            paths(root.left,arr,i);
            paths(root.right,arr,i);
        }
    }
    void paths(int[] arr,int i){
        StringBuilder sb=new StringBuilder();
        for(int j=0;j<i;j++){
            sb.append(arr[j]+"->");
        }
        result.add(new String(sb).substring(0,sb.length()-2));
    }
    int getTreeSize(TreeNode root){
        if(root==null)
            return 0;
        int size=1;
        size+=getTreeSize(root.left);
        size+=getTreeSize(root.right);
        return size ;
    }
}
