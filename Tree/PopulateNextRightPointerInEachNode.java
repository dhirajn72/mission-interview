/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null)
            return null;
        levelOrder(root);
        return root;
    }
    public void  levelOrder(Node root) {
        if(root==null)
            return ;
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Node> list=new ArrayList<>();
        while(!q.isEmpty()){
            Node temp=q.poll();
            if(temp!=null){
                list.add(temp);
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            else{
                for(int i=1;i<list.size();i++){
                    list.get(i-1).next=list.get(i);
                }
                if(!q.isEmpty()){
                    q.offer(null);
                }
                list.clear();
            }
        }
    }
}
