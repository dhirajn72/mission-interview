class Solution {
    int[] arr=null;
    int index=0;
    public int getMinimumDifference(TreeNode root) {
        if(root==null)
            return 0;
        arr=new int[getSize(root)];
        int min=Integer.MAX_VALUE;
        levelOrder(root);
        for(int i=1;i<arr.length;i++){
            min=Math.min(min,arr[i]-arr[i-1]);
        }
        return min;
    }

    int getSize(TreeNode root){
        if(root==null)
            return 0;
        int size=1;
        size+=getSize(root.left);
        size+=getSize(root.right);
        return size;
    }
    void levelOrder(TreeNode root){
        if(root==null)
            return ;
        Stack<TreeNode> s=mew Stack<>();
        while(!s.isEmpty()||root!=null){
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
}
