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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode p1=l1;
        ListNode p2=l2;
        
        ListNode head=new ListNode(0);
        ListNode p=head;
        int sum=0;
        while(p1!=null || p2!=null){
            sum /=10;
            if(p1!=null){
                sum+=p1.val;
                p1=p1.next;
            }
            if(p2!=null){
                sum+=p2.val;
                p2=p2.next;
            }
            p.next=new ListNode(sum%10);
            p=p.next;
        }
        if(sum/10==1)
            p.next=new ListNode(1);
        
        return head.next;
    }
}
