/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<String> list=new ArrayList<>();
    Map<Integer,String> map=new HashMap<>();
    public String smallestFromLeaf(TreeNode root) {
        if(root==null)
            return null;
        map.put(0,"a");map.put(1,"b");map.put(2,"c");map.put(3,"d");map.put(4,"e");map.put(5,"f");
        map.put(6,"g");map.put(7,"h");map.put(8,"i");map.put(9,"j");map.put(10,"k");map.put(11,"l");
        map.put(12,"m");map.put(13,"n");map.put(14,"o");map.put(15,"p");map.put(16,"q");map.put(17,"r");
        map.put(18,"s");map.put(19,"t");map.put(20,"u");map.put(21,"v");map.put(22,"w");map.put(23,"x");
        map.put(24,"y");map.put(25,"z");

        int[] arr=new int[10000];
        findPaths(root,arr,0);
        Collections.sort(list);
        return list.get(0);
    }
    void findPaths(TreeNode root,int[] arr,int i){
        if(root==null)
            return;
        arr[i++]=root.val;
        if(root.left==null && root.right==null){
            path(arr,i);
        }
        else{
            findPaths(root.left,arr,i);
            findPaths(root.right,arr,i);
        }
    }
    void path(int[] arr,int i){
        StringBuilder sb=new StringBuilder();
        for(int j=i-1;j>=0;j--){
            sb.append(map.get(arr[j]));
        }
        list.add(sb.toString());
    }
}
