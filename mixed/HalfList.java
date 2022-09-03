public class HalfList {
    
    static ListNode getHalf(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(slow!=null && fast!=null){
            if(slow.next==null||fast.next==null)
                return slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        return head;
    }


   static class ListNode{
        int val;
        ListNode next;
        ListNode(int data){
            this.val=data;
        }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(6);
        head.next=new ListNode(1);
        head.next.next=new ListNode(5);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(4);
        head.next.next.next.next.next=new ListNode(2);
        
        ListNode l1=head;
        ListNode half=getHalf(head);
        ListNode l2=half.next;
        half.next=null;
    }

}