class Solution {
    /*
    Runtime: 5 ms, faster than 14.73% of Java online submissions for Remove Duplicates from Sorted List.
    */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return null;
        Set<Integer> set=new LinkedHashSet<Integer>();
        ListNode temp=head;
        while(temp!=null){
            set.add(temp.val);
            temp=temp.next;
        }
        ListNode prev=null;
        temp=head;
        
        for(int e:set){
            temp.val=e;
            prev=temp;
            temp=temp.next;
        }
        prev.next=null;
        return head;
    }
}
