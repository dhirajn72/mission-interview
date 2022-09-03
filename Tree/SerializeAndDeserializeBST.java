/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return null;
        StringBuilder sb=new StringBuilder();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                sb.append(temp.val).append(",");
                q.offer(temp.left);
                q.offer(temp.right);
            }
            else{
                sb.append("#").append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null)
            return null;
        String[] arr=data.split(",");
        TreeNode root=new TreeNode(Integer.valueOf(arr[0]));
        for(int i=1;i<arr.length;i++){
            insert(root,arr[i]);
        }
        return root;
    }
    TreeNode insert(TreeNode root,String val){
        if(root==null){
            root=new TreeNode(Integer.valueOf(val));
            return root;
        }
        else{
            if(val.equals("#")){
                if(root.left==null)
                    root.left=null;
                else if(root.right==null)
                    root.right=null;
            }
            else{
                if(Integer.valueOf(val)<root.val){
                    root.left=insert(root.left,val);
                }
                else{
                    root.right=insert(root.right,val);
                }
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;/ return ans;
