class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        ListNode copy=new ListNode(0);
        ListNode temp=head;
        ListNode tempCopy=copy;
        while(temp!=null){
            ListNode node=new ListNode(temp.val);
            tempCopy.next=node;
            tempCopy=tempCopy.next;
            temp=temp.next;
        }
        copy=copy.next;
        ListNode reversed=getReversed(copy);
        temp=head;
        while(reversed!=null){
            if(reversed.val!=temp.val)
                return false;
            reversed=reversed.next;
            temp=temp.next;
        }
        return true;
    }
    ListNode getReversed(ListNode head){
        ListNode currrent=head,prev=null;
        while(currrent!=null){
            ListNode node=currrent.next;
            currrent.next=prev;
            prev=currrent;
            currrent=node;
        }
        return prev;
    }
}
