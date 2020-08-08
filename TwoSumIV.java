class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
            return false;
        int[] arr=new int[getTreeSize(root)];
        int index=0;
        Stack<TreeNode> s=new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp=s.pop();
            if(temp!=null){
                arr[index++]=temp.val;
                if(temp.left!=null)
                    s.push(temp.left);
                if(temp.right!=null)
                    s.push(temp.right);
            }
        }
        if(arr.length<2)
            return false;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            map.put(i,i);
        }
        for(int i=0;i<arr.length;i++){
            int find=k-arr[i];
            if(map.containsKey(find) && arr[i]!=map.get(find))
                return true;
        }
        return false;
    }
    int getTreeSize(TreeNode root){
        if(root==null)
            return 0;
        int size=1;
        size+=getTreeSize(root.left);
        size+=getTreeSize(root.right);
        return size;
    }
}
