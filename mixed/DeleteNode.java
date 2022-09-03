class Solution {
    public void deleteNode(ListNode node) {
        if(node==null)
            return ;
        ListNode temp=node;
        ListNode prev=null;
        while(temp!=null && temp.next!=null){
            temp.val=temp.next.val;
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;
    }

    ListNode getReversed(ListNode head){
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
