
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode prev=null,current=head;
        while(current!=null){
            ListNode node=current.next;
            current.next=prev;
            prev=current;
            current=node;
        }
        return prev;
    }
}

