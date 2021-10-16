/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    boolean result=false;
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null)
            return result;
        int[] arr=new int[1000];

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode temp=q.poll();
            if(temp!=null){
                if(temp.val==head.val){
                    findList(head,temp,arr,0);
                }
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
        }
        return result;
    }
    void findList(ListNode head,TreeNode root,int[] arr,int i){
        if(root==null)
            return;
        arr[i++]=root.val;
        if(root.left==null && root.right==null){
            compare(arr,i,head);
        }
        else{
            findList(head,root.left,arr,i);
            findList(head,root.right,arr,i);
        }
    }
    void compare(int[] arr,int i,ListNode head){
        if(head==null){
            result=true;
        }
        ListNode temp=head;
        int index=0;
        while(index<arr.length && arr[index]!=temp.val){
            index++;
        }
        for(int j=index;j<i;j++){
            if(temp!=null && arr[j]==temp.val){
                temp=temp.next;
            }
            else{
                break;
            }
            if(temp==null)
                result=true;
        }
    }
}
