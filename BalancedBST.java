class Solution {

    int[] arr=null;
    int index=0;
    public TreeNode balanceBST(TreeNode root) {
        if(root==null)
            return root;
        arr=new int[getTreeSize(root)];
        inOrder(root);
        return buildTree(arr,0,arr.length-1);
    }
    void inOrder(TreeNode root){
        if(root==null)
            return ;
        Stack<TreeNode> s=new Stack<>();
        while(!s.isEmpty() || root!=null){
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
    int getTreeSize(TreeNode root){
        if(root==null)
            return 0;
        int size=1;
        size+=getTreeSize(root.left);
        size+=getTreeSize(root.right);
        return size;
    }
    TreeNode buildTree(int[] arr, int low,int high){
        if(low>high)
            return null;
        int mid=(low+high)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=buildTree(arr,low,mid-1);
        root.right=buildTree(arr,mid+1,high);
        return root;
    }
}
