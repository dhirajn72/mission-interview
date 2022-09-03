class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if(head==null)
            return null;
        int size=getSize(head);
        int[] result=new int[size];
        if(head.next==null){
            return new int[]{0};
        }
        int index=0;
        ListNode p1=head,p2=head;
        while(p1!=null){
            while(p2!=null){
                if(p2.val>p1.val)
                    break;
                p2=p2.next;
            }
            if(p2!=null)
                result[index++]=p2.val;
            else
                result[index++]=0;
            p1=p1.next;
            p2=p1;
        }
        return result;
    }

    int getSize(ListNode head){
        if(head==null)
            return 0;
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        return size;
    }
}
