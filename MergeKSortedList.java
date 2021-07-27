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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;
        if(lists.length==1)
            return lists[0];
        ListNode result=null;
        ListNode p=result,q=null;
        for(ListNode list:lists){
            if(result==null)
                result=list;
            else{
               result= merge(result,list);
            }
        }
        return result;
    }
    ListNode merge(ListNode l1,ListNode l2){
        ListNode head=new ListNode(0);
        ListNode p1=l1,p=head;
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
        if(p1!=null){
            p.next=p1;
        }
        if(p2!=null){
            p.next=p2;
        }
        return head.next;
    }
}
