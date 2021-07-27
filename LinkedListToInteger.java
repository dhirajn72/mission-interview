class Solution {
    public int getDecimalValue(ListNode head) {
        if(head==null)
            return 0;
        int size=getSize(head);
        ListNode temp=head;
        int result=0;
        while(temp!=null){
            result+=Math.pow(2,size--);
            temp=temp.next;
        }
        return result;
    }
    public int getSize(ListNode head){
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }
}
