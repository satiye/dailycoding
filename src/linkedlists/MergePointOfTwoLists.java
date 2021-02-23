package linkedlists;
/*
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 */
public class MergePointOfTwoLists {
	public ListNode solution(ListNode headA, ListNode headB) {
        if(headA == null || headB== null) return null;
       
        ListNode p1 = headA;
        ListNode p2 = headB;
        
        while(p1 != p2){
            if(p1 == null){
                p1 = headB;
            }else{
                p1 = p1.next;
            }
            
            if(p2 == null){
                p2 = headA;
            }else{
                p2 = p2.next;
            }
        }
       
       return p1;
   }
	public static void main(String[] args){
		MergePointOfTwoLists mergePointOfTwoLists = new MergePointOfTwoLists();
	 
		ListNode headA = new ListNode(3);
		headA.next = new ListNode(6);
		headA.next.next = new ListNode(9);
		headA.next.next.next = new ListNode(15);
		headA.next.next.next.next = new ListNode(30);

		ListNode headB = new ListNode(10);
		headB.next = headA.next.next.next;
	 
	    System.out.println(mergePointOfTwoLists.solution(headA, headB).val);
	}
}
