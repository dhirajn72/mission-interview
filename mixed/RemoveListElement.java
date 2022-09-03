class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)
            return head;
        Set<Integer> set=new LinkedHashSet<>();
        ListNode temp=head;
        while(temp!=null){
            if(temp.val!=val)
                set.add(temp.val);
            temp=temp.next;
        }
        if(set.isEmpty())
            return null;
        temp=head;
        ListNode prev=null;
        for(int e:set){
            temp.val=e;
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;
        return head;
    }
}
