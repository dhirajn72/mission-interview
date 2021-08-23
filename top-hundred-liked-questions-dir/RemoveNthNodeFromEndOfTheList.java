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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return head;

        int size=getSize(head);
        int nodeToRemove=size-n;
        if(nodeToRemove<0)
            return head;
        if(nodeToRemove==0)
            return head=head.next;    
        ListNode temp=head;
        int prev=1;
        while(temp!=null && nodeToRemove!=prev){
            prev++;
            temp=temp.next;
        }
        if(temp!=null && temp.next!=null){
            temp=temp.next.next;
        }
        return head;
    }
    int getSize(ListNode head){
        if(head==null)
            return 0;
        int size=0;
        return 1+getSize(head);
    }
}

