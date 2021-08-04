// Merge 2 sorted LinkedList

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curr = new ListNode();
        ListNode d = curr;   // d is like a pointer
        while (l1!=null && l2!=null){
            if (l1.val <= l2.val){
                d.next = l1;
                l1 = l1.next;
            }else{
                d.next = l2;
                l2 = l2.next;
            }
//             Go to next node
            d = d.next;
        }
        d.next = l1 == null ? l2:l1;
        return curr.next;
    }
}
