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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null)
            return head;

        int count=0;
        ListNode temp=head,prev=head;
        while(temp!=null){
            prev=temp;
            temp=temp.next;
            if(count==left)
                break;
            count++; 
        }
        prev.next=null;
        ListNode start=temp;
        ListNode prev1=start;
        while(temp!=null){
            prev1=temp;
            temp=temp.next;
            if(count==right)
                break;
            count++; 
        }
        prev1.next=null;
        ListNode chunk=reverseList(start);
        
       
        
        ListNode p=head,q=null;
        for( p=head; p!=null; q=p,p=p.next);
        q.next=chunk;

        for( p=prev; p!=null; q=p,p=p.next);
        q.next=temp;
        return head;

    }
     ListNode reverseList(ListNode head){
         ListNode current=head,prev=null;
         while(current!=null){
             ListNode node=current.next;
             current.next=prev;
             prev=current;
             current=node;
         }
        ListNode temp=prev;
        while(temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
        return prev;
     }
}
