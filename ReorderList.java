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
    public void reorderList(ListNode head) {
        if(head==null||head.next==null)
            return;

        ListNode slowPtr=head;
        ListNode fastPtr=head;
        ListNode prev=null;
        while(fastPtr!=null && fastPtr.next!=null){
            prev=slowPtr;
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
        }
        prev.next=null;
        ListNode secondHalf=reverseList(slowPtr);
        mergeLists(head,secondHalf);
        
    }
    void mergeLists(ListNode head1,ListNode head2){
        while(head2!=null){
            ListNode next=head1.next;
            head1.next=head2;
            head1=head2;
            head2=next;
        }
    }
    ListNode reverseList(ListNode head){
        if(head==null)
            return head;
        ListNode current=head;
        ListNode prev=null;
        while(current!=null){
            ListNode node=current.next;
            current.next=prev;
            prev=current;
            current=node;
        }
        return prev;
    }

}
