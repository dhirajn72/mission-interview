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
        if(head==null||root==null)
            return false;
        int[] arr=new int[getSize(root)];
        treePath(root,arr,0,head);
        isSubPath(head,root.left);
        if(result)
            return result;
        isSubPath(head,root.right);
        return result;
    }
    void treePath(TreeNode root,int[] arr,int i,ListNode head){
        if(root==null)
            return;
        arr[i++]=root.val;
        if(root.left==null && root.right==null){
            print(arr,i,head);
        }
        else{
            treePath(root.left,arr,i,head);
            treePath(root.right,arr,i,head);
        }
    }
    void print(int[] arr,int i,ListNode head){
        ListNode temp=head;
        int j=0;
        while(j<i && temp!=null && temp.val==arr[j++]){
            temp=temp.next;
        }
        if(temp==null)
            result=true;
    }
    int getSize(TreeNode root){
        if(root==null)
            return 0;
        int size=1;
        size+=getSize(root.left);
        size+=getSize(root.right);
        return size;

    }
}
