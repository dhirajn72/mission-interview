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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return head;
        int size=getSize(head);
        if(size==k)
            return reverseList(head);

        List<ListNode> list=new ArrayList<>();
        splitList(head,k,list);

        ListNode result=null,q=result,p=result;
        for(ListNode node:list){
            if(result==null){
                result=node;
            }
            else{
                for(p=result;(q=p.next)!=null;p=q);
                p.next=node;
            }
        }
        return result;

    }
    ListNode reverseList(ListNode head){
        if(head==null)
            return head;
        ListNode current=head,prev=null;
        while(current!=null){
            ListNode node=current.next;
            current.next=prev;
            prev=current;
            current=node;
        }
        return prev;
    }
    void splitList(ListNode head,int k,List<ListNode> list){
        ListNode temp=head,prev=head,head1=head;
        int count=0;
        while(temp!=null){
            while(count++<k && temp!=null){
                prev=temp;
                temp=temp.next;

            }

            prev.next=null;
            int size=getSize(head1);
            if(size==k)
                list.add(reverseList(head1));
            else
                list.add(head1);
            head1=temp;
            count=0;
            if(temp==null ||temp.next==null){
                list.add(temp);
                break;
            }
        }
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
