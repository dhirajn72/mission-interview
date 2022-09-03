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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)        
            return head;;
        
        ListNode slowPtr=head;
        ListNode fastPtr=head;
        ListNode prev=null;
        while(fastPtr!=null && fastPtr.next!=null){
            prev=slowPtr;
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
        }
        prev.next=null;
        ListNode firstHalf=sortList(head);
        ListNode secondHalf=sortList(slowPtr);
        return merge(firstHalf,secondHalf);
    }
    ListNode merge(ListNode l1,ListNode l2){
        ListNode head=new ListNode(0);
        ListNode p=head;
        ListNode p1=l1;
        ListNode p2=l2;
        while(p1!=null && p2!=null){
            if(p1.val<p2.val){
                p.next=p1;
                p1=p1.next;
            }
            else{
                p.next=p2;
                p2=p2.next;
            }
            p=p.next;
        }
        if(p1!=null)
            p.next=p1;

        if(p2!=null)
            p.next=p2;

            
        return head.next;
    }
}
