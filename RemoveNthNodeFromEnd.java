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
        int index=size-n;
        int count=1;
        ListNode temp=head;
        while(temp!=null && count!=index){
            temp=temp.next;
            count++;
        }
        if(count==index && temp!=null && temp.next!=null){
            temp.next=temp.next.next;
            return head;
        }
        if(size==n){
            head=head.next;
            return head;
        }
        return head;
    }
    int getSize(ListNode head){
        if(head==null)
            return 0;
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }
}
