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
   public ListNode swapNodes(ListNode head, int k) {
        if(head==null)
            return head;
        int size=getListSize(head);
        int[] arr=new int[size];
        ListNode temp=head;
        int index=0;
        while(temp!=null){
            arr[index++]=temp.val;
            temp=temp.next;
        }
        int t=arr[k-1];
        arr[k-1]=arr[arr.length-k];
        arr[arr.length-k]=t;
        
        temp=head;
        for(int e:arr){
            temp.val=e;
            temp=temp.next;
        }
        return head;
   }

   int getSize(ListNode head){
       int size=0;
       ListNode temp=head;
       while(temp!=null){
           size++;
           temp=temp.next;
       }
       return size;

   }
}
