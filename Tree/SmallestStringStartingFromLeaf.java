
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
    List<String> result=new ArrayList<>();
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
        
        backtrack(root,new ArrayList<>());
        Collections.sort(result);
        return result.get(0);
    }

    void backtrack(TreeNode root,List<Integer> list){
        if(root==null)
            return;
        list.add(root.val);
        if(root.left==null && root.right==null){
            addPath(list);
        }
        
        if(root.left!=null){
            backtrack(root.left,list);
            list.remove(list.size()-1);
        }
        if(root.right!=null){
            backtrack(root.right,list);
            list.remove(list.size()-1);
        }
    }
    void addPath(List<Integer> list){
        StringBuilder sb=new StringBuilder();
        for(int i=list.size()-1;i>=0;i--){
            sb.append(map.get(list.get(i)));
        }
        result.add(sb.toString());
    }
}

