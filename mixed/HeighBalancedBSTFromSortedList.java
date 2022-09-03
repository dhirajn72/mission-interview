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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        int size=getSize(head);
        int[] arr=new int[size];
        int index=0;
        ListNode temp=head;
        while(temp!=null){
            arr[index++]=temp.val;
            temp=temp.next;
        }
        return buildBST(arr,0,arr.length-1);
    }
    int getSize(ListNode head){
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }
    TreeNode buildBST(int[] arr,int low,int high){
        if(low>high)
            return null;

        int mid=(low+high)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=buildBST(arr,low,mid-1);
        root.right=buildBST(arr,mid+1,high);
        return root;
    }
}
