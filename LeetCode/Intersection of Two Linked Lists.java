// Linked List (ListNode) : LeetCode Java code

public class Solution {
    
    public static int len(ListNode a){
        int len = 1;
        while (a.next != null){
            a = a.next;
            len++;
        }
        return len;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         Find the length of Lists
        int lena = len(headA), lenb = len(headB);
//         Make the starts same
        if (lena>lenb){
            while (lena>lenb){
                headA = headA.next;
                lena--;
            }
        }
        else{
            while (lenb>lena){
                headB = headB.next;
                lenb--;
            }
        }
//         Find intersection
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
