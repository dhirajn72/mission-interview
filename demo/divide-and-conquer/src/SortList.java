public class SortList {
	static public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode fastPtr=head;
		ListNode slowPtr=head;
		ListNode prev=null;
		while(fastPtr!=null && fastPtr.next!=null){
			prev=slowPtr;
			slowPtr=slowPtr.next;
			fastPtr=fastPtr.next.next;
		}
		prev.next=null;
		ListNode firsthalf=sortList(head);
		ListNode secondHalf=sortList(slowPtr);
		return merge(firsthalf,secondHalf);
	}
	static ListNode merge(ListNode l1,ListNode l2){
		ListNode head=new ListNode();
		ListNode p=head;
		ListNode p1=l1;
		ListNode p2=l2;
		while(p1!=null && p2!=null){
			if(p1.val<p2.val){
				p.next=p1;
				p1=p1.next;
			}
			else{
				p.next=p2;
				p2=p2.next;
			}
			p=p.next;
		}
		if(p1!=null)
			p.next=p1;
		if(p2!=null)
			p.next=p2;
		return head.next;
	}
	public static void main(String[] args){
		ListNode head=new ListNode(4);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(1);
		head=sortList(head);
		ListNode temp=head;
		while(temp!=null){
			System.out.print(temp.val+",");
			temp=temp.next;
		}
	}
}
