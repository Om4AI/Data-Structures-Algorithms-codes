public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lena = getLength(headA), lenb = getLength(headB);
        
        // Bring both of them to same length
        while(lena>lenb){
            headA = headA.next;
            lena--;
        }
        while(lenb>lena){
            headB = headB.next;
            lenb--;
        }
        
        // Same length - Search for common node now
        // Full node must be same - Value & Next pointer both
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    
    public static int getLength(ListNode head){
        int c = 0;
        while(head.next!=null){
            c++;
            head = head.next;
        }
        return c;
    }
}
