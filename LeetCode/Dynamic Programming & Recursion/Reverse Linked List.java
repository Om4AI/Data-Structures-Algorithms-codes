// Code by @Om
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr!=null){
            ListNode next = curr.next;  //Store the next value to a node
            curr.next = prev; //Point to previous node
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
