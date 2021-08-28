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
    ListNode head=null;
    ListNode temp=null;
    public ListNode mergeKLists(ListNode[] lists) {
        
        for(ListNode list:lists){
            head=mergeList(head,list);
        }
        return head;
    }
    ListNode mergeList(ListNode l1,ListNode l2){
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        
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
