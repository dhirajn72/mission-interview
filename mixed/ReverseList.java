class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current=head,prev=null;
        while(current!=null){
            ListNode node=current.next;
            current.next=prev;
            prev=current;
            current=node;
        }
        return prev;
    }
}
